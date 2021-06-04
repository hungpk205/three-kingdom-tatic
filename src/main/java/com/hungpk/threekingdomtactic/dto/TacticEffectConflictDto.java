package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class TacticEffectConflictDto {
    private Long id;
    private TacticDto tactic;
    private EffectConflictDto effectConflict;
}
