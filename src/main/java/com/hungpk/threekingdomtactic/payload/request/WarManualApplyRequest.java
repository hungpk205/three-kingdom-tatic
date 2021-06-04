package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.TroopDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class WarManualApplyRequest {
    private WarManualDto warManual;
    private TroopDto troop;
}
