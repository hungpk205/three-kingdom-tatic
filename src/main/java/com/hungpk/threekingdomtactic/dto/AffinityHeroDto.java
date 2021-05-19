package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class AffinityHeroDto {
    private Long id;
    private HeroDto name;
    private AffinityDto affinity;
}
