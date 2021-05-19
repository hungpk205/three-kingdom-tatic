package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.LineupDto;
import com.hungpk.threekingdomtactic.dto.TacticDto;
import lombok.Data;

@Data
public class TacticLineupRequest {
    private LineupDto lineup;
    private TacticDto tactic;
}
