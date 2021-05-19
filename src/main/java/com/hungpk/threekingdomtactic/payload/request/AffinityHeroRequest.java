package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.AffinityDto;
import com.hungpk.threekingdomtactic.dto.HeroDto;
import lombok.Data;

@Data
public class AffinityHeroRequest {
    private HeroDto hero;
    private AffinityDto affinity;
}
