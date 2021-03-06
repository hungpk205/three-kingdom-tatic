package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class WarManualDto {
    private Long id;
    private String name;
    private String info;
    private EffectDto effect;
    private TargetDto target;
    private Double changeToTrigger;
}
