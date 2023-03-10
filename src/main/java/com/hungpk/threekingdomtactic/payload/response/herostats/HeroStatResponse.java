package com.hungpk.threekingdomtactic.payload.response.herostats;

import com.hungpk.threekingdomtactic.payload.response.stats.StatResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroStatResponse {
    private Long id;
    private Integer baseStat;
    private Float increase;
    private StatResponse stat;
}
