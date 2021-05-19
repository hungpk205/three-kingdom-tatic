package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.TacticDto;
import com.hungpk.threekingdomtactic.dto.TroopDto;
import lombok.Data;

@Data
public class TacticApplyRequest {
    private TacticDto tactic;
    private TroopDto troop;
}
