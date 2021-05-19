package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.HeroDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class RecommendWarManualRequest {
    private HeroDto name;
    private WarManualDto warManual;
}
