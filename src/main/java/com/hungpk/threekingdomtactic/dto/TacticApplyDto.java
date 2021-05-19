package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class TacticApplyDto {
    private Long id;
    private TacticDto tactic;
    private TroopDto troop;
}
