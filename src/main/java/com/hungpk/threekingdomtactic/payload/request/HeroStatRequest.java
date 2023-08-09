package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.enums.StatEnum;
import lombok.Data;

import java.util.List;

@Data
public class HeroStatRequest {
    private StatEnum stat;
    private Integer baseStat;
    private Float increase;
}
