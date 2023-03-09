package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.HeroDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class RecommendedWarManualRequest {
    private HeroDto hero;
    private WarManualDto warManual;
}
