package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class TacticLineupDto {
    private Long id;
    private LineupDto lineup;
    private TacticDto tactic;
}
