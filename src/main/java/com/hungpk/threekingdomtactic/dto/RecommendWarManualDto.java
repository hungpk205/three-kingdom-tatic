package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class RecommendWarManualDto {
    private Long id;
    private HeroDto hero;
    private WarManualDto warManual;
}
