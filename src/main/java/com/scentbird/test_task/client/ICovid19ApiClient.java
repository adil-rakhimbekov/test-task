package com.scentbird.test_task.client;

import com.scentbird.test_task.model.ByCountryTotalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


/****************************
 * @author adilrakhimbekov
 * @since 7/20/20
 ***************************/

@FeignClient(value = "covid19api", url = "https://api.covid19api.com/")
public interface ICovid19ApiClient {
    @GetMapping("/total/country/{countrySlug}/status/confirmed?from={beginDate}&to={endDate}")
    List<ByCountryTotalResponse> getByCountryTotal(@PathVariable("countrySlug") String countrySlug,
                                                   @PathVariable("beginDate") String beginDate,
                                                   @PathVariable("endDate") String endDate);
}
