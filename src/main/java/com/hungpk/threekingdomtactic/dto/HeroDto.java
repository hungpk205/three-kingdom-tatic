package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class HeroDto {
    private Long id;
    private String name;
    private String nameVn;
    private Integer cost;
    private Integer start;
    private String image;
    private String info;
    private TacticDto officialTactic;
    private TacticDto inheritTactic;
    private CountryDto country;
    private SeasonDto season;
}
