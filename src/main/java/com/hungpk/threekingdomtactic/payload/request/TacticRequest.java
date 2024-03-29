package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.EffectConflictDto;
import com.hungpk.threekingdomtactic.dto.EffectDto;
import com.hungpk.threekingdomtactic.dto.TargetDto;
import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;
import com.hungpk.threekingdomtactic.enums.TargetTypeEnum;
import lombok.Data;

@Data
public class TacticRequest {
    private String name;
    private String info;
    private String maxLvInfo;
    private EffectDto effect;
    private QualityEnum quality;
    private TacticTypeEnum tacticType;
    private TargetTypeEnum targetType;
    private Long changeToTrigger;
    private EffectConflictDto effectConflict;
    private int slot;
    private int quantity;
}
