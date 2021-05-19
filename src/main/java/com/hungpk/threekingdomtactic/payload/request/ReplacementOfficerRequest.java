package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.HeroDto;
import com.hungpk.threekingdomtactic.dto.LineupDto;
import lombok.Data;

@Data
public class ReplacementOfficerRequest {
    private LineupDto lineup;
    private HeroDto hero;
}
