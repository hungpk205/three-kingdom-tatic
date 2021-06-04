package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.EffectConflictDto;
import com.hungpk.threekingdomtactic.dto.TacticDto;
import lombok.Data;

@Data
public class TacticEffectConflictRequest {
    private TacticDto tactic;
    private EffectConflictDto effectConflict;
}
