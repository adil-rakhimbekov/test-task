package com.scentbird.test_task.service.impl;

import com.scentbird.test_task.model.ByCountryTotalResponse;
import com.scentbird.test_task.model.CountriesRequest;
import com.scentbird.test_task.model.CountriesStatResponse;
import com.scentbird.test_task.service.ICovid19ApiCacheProxyService;
import com.scentbird.test_task.service.ICovid19ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;
import java.util.ListIterator;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Slf4j
@Service
@RequiredArgsConstructor
public class Covid19ApiServiceImpl implements ICovid19ApiService {
    private final ICovid19ApiCacheProxyService proxyService;

    @Override
    @Cacheable("statsByList")
    public CountriesStatResponse getStatsByList(CountriesRequest countriesRequest) {
        final CountriesStatResponse result = new CountriesStatResponse();
        countriesRequest.getCountries().forEach(countrySlug -> {
            final String beginDate = countriesRequest.getBeginDate().minusDays(1) // для получения разницы берем еще день ранее
                    .toInstant(ZoneOffset.UTC).toString();
            final String endDate = countriesRequest.getEndDate().toInstant(ZoneOffset.UTC).toString();
            try {
                final List<ByCountryTotalResponse> totalResponsesList = proxyService.getByCountryTotal(countrySlug, beginDate, endDate);

                final ListIterator<ByCountryTotalResponse> iterator = totalResponsesList.listIterator();
                if (iterator.hasNext()) {
                    ByCountryTotalResponse prev = iterator.next();
                    while (iterator.hasNext()) {
                        ByCountryTotalResponse curr = iterator.next();
                        final Integer diff = curr.getCases() - prev.getCases();
                        if (result.getMaxConfirmed() < diff) {
                            result.setMaxConfirmed(diff);
                        }
                        if (result.getMinConfirmed() > diff) {
                            result.setMinConfirmed(diff);
                        }
                        prev = curr;
                    }
                }
            } catch (RuntimeException runtimeException) {
                log.warn("", runtimeException);
            }
        });
        return result;
    }
}
