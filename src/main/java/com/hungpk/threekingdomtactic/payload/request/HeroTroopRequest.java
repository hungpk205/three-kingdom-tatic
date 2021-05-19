package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.HeroDto;
import com.hungpk.threekingdomtactic.dto.TroopDto;
import com.hungpk.threekingdomtactic.enums.QualityEnum;
import lombok.Data;

@Data
public class HeroTroopRequest {
    private HeroDto hero;
    private TroopDto troop;
    private QualityEnum quality;
}
