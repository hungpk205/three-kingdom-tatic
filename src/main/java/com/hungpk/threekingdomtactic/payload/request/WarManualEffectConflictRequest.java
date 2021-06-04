package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.EffectConflictDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class WarManualEffectConflictRequest {
    private WarManualDto warManual;
    private EffectConflictDto effectConflict;
}
