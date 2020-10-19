package com.scentbird.test_task.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/****************************
 * @author adilrakhimbekov
 * @since 10/19/20
 ***************************/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class ByCountryTotalResponse {
    @JsonProperty("Country")
    String country;
    @JsonProperty("Cases")
    Integer cases;
    @JsonProperty("Date")
    LocalDateTime date;
}
