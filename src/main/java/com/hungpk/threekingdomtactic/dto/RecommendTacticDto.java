package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class RecommendTacticDto {
    private Long id;
    private HeroDto hero;
    private TacticDto tactic;
}
