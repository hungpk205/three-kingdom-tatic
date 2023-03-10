package com.hungpk.threekingdomtactic.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class HeroStatRequest {
    private Long statId;
    private Integer baseStat;
    private Float increase;
}
