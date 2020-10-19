package com.scentbird.test_task.service;

import com.scentbird.test_task.model.CountriesRequest;
import com.scentbird.test_task.model.CountriesStatResponse;
import org.springframework.stereotype.Service;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Service
public interface ICovid19ApiService {
    CountriesStatResponse getStatsByList(CountriesRequest countriesRequest);
}
