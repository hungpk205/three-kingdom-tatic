package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.EffectConflictDto;
import com.hungpk.threekingdomtactic.dto.EffectDto;
import com.hungpk.threekingdomtactic.dto.TargetDto;
import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;
import lombok.Data;

@Data
public class TacticRequest {
    private String name;
    private String info;
    private String maxLvlInfo;
    private EffectDto effect;
    private TargetDto target;
    private QualityEnum quality;
    private TacticTypeEnum tacticType;
    private Long changeToTrigger;
    private EffectConflictDto effectConflict;
    private int slot;
}
