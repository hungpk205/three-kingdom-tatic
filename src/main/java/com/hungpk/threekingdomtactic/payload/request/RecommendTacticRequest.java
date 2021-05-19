package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.HeroDto;
import com.hungpk.threekingdomtactic.dto.TacticDto;
import lombok.Data;

@Data
public class RecommendTacticRequest {
    private HeroDto hero;
    private TacticDto tactic;
}
