package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.EffectDto;
import com.hungpk.threekingdomtactic.dto.TargetDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class WarManualRequest {
    private String name;
    private String info;
    private WarManualDto warManual;
    private EffectDto effect;
    private TargetDto target;
    private Double changeToTrigger;
}
