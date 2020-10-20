package com.scentbird.test_task.service.impl;

import com.scentbird.test_task.client.ICovid19ApiClient;
import com.scentbird.test_task.model.ByCountryTotalResponse;
import com.scentbird.test_task.service.ICovid19ApiCacheProxyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Slf4j
@Service
@RequiredArgsConstructor
public class Covid19ApiCacheProxyServiceImpl implements ICovid19ApiCacheProxyService {
    private final ICovid19ApiClient covid19ApiClient;

    @Override
    @Cacheable("countryTotal")
    public List<ByCountryTotalResponse> getByCountryTotal(String countrySlug, String beginDate, String endDate) {
        return covid19ApiClient.getByCountryTotal(countrySlug, beginDate, endDate);
    }
}
