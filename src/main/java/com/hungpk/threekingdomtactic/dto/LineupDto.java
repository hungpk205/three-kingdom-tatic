package com.hungpk.threekingdomtactic.dto;

import lombok.Data;

@Data
public class LineupDto {
    private Long id;
    private HeroDto hero;
    private GroupDto group;
    private boolean isCommander;
}
