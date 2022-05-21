package com.siripiri.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDTO {
    public Long id;
    public String house;
    public String office;
    public String personal;
}
