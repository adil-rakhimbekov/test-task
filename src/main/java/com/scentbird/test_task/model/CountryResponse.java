package com.scentbird.test_task.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Data
@ToString
public class CountryResponse {
    @JsonProperty("Country")
    String country;
    @JsonProperty("Slug")
    String slug;
    @JsonProperty("ISO2")
    String iso2;
}
