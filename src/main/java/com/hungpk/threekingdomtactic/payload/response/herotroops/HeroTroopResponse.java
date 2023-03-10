package com.hungpk.threekingdomtactic.payload.response.herotroops;

import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.payload.response.troop.TroopResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroTroopResponse {
    private Long id;
    private TroopResponse troop;
    private QualityEnum qualityEnum;
}
