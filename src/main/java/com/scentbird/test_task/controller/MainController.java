package com.scentbird.test_task.controller;

import com.scentbird.test_task.model.CountriesRequest;
import com.scentbird.test_task.model.CountriesStatResponse;
import com.scentbird.test_task.service.ICovid19ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MainController {
    private final ICovid19ApiService covid19ApiService;

    @GetMapping(value = "/statsByList")
    public ResponseEntity<CountriesStatResponse> getStatsByList(@RequestBody CountriesRequest countriesRequest) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(covid19ApiService.getStatsByList(countriesRequest));
    }
}
