package com.hungpk.threekingdomtactic.payload.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class CountryResponse implements Serializable {
    private Long id;
    private String name;
    private String nameVn;
}
