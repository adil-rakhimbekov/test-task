package com.scentbird.test_task.model;

import lombok.Data;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Data
public class CountriesStatResponse {
    Integer maxConfirmed = Integer.MIN_VALUE;
    Integer minConfirmed = Integer.MAX_VALUE;
}
