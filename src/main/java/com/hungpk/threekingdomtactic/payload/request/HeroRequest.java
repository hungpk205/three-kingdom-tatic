package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.CountryDto;
import com.hungpk.threekingdomtactic.dto.SeasonDto;
import com.hungpk.threekingdomtactic.dto.TacticDto;
import lombok.Data;

@Data
public class HeroRequest {
    private String name;
    private String nameVn;
    private Integer cost;
    private Integer star;
    private String image;
    private String info;
    private TacticDto officialTactic;
    private TacticDto inheritTactic;
    private CountryDto country;
    private SeasonDto season;
}
