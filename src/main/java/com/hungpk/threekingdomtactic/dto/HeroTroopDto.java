package com.hungpk.threekingdomtactic.dto;

import com.hungpk.threekingdomtactic.enums.QualityEnum;
import lombok.Data;

@Data
public class HeroTroopDto {
    private Long id;
    private HeroDto hero;
    private TroopDto troop;
    private QualityEnum quality;
}
