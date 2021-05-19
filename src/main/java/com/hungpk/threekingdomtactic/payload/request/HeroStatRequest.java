package com.hungpk.threekingdomtactic.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class HeroStatRequest {
    private Long heroId;
    private List<HeroStatInner> heroStat;

    @Data
    public static class HeroStatInner {
        private Float increase;
        private Long statId;
    }
}
