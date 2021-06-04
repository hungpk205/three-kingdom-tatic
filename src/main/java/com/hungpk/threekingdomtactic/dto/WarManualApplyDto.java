package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class WarManualApplyDto {
    private Long id;
    private WarManualDto warManual;
    private TroopDto troop;
}
