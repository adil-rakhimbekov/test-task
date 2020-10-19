package com.scentbird.test_task.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Data
public class CountriesRequest {
    List<String> countries = new ArrayList<>();
    LocalDateTime beginDate;
    LocalDateTime endDate;
}
