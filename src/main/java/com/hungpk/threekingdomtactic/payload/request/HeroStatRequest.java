package com.hungpk.threekingdomtactic.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class HeroStatRequest {
    private Long id;
    private Long heroId;
    private Float increase;
    private Long statId;
}
