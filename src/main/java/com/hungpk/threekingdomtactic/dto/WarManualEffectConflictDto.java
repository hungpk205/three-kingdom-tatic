package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class WarManualEffectConflictDto {
    private Long id;
    private WarManualDto warManual;
    private EffectConflictDto effectConflict;
}
