package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.GroupDto;
import com.hungpk.threekingdomtactic.dto.HeroDto;
import lombok.Data;

@Data
public class LineupRequest {
    private HeroDto hero;
    private GroupDto group;
    private boolean isCommander;
}
