package com.scentbird.test_task.service;

import com.scentbird.test_task.model.ByCountryTotalResponse;

import java.util.List;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
public interface ICovid19ApiCacheProxyService {
    List<ByCountryTotalResponse> getByCountryTotal(String countrySlug, String beginDate, String endDate);
}
