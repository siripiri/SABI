package com.siripiri.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverPersonalDTO {
    public Long id;
    public String name;
    public int age;
    public String address;
    public PhoneNumberDTO phoneNumber;
    public String childrenDetails;

    @JsonProperty("driver_url")
    public String url;
}
