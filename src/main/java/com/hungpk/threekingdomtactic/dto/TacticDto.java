package com.hungpk.threekingdomtactic.dto;

import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;
import lombok.Data;

@Data
public class TacticDto {
    private Long id;
    private String name;
    private String info;
    private String maxLvlInfo;
    private EffectDto effect;
    private TargetDto target;
    private QualityEnum quality;
    private TacticTypeEnum tacticType;
    private Long changeToTrigger;
    private EffectConflictDto effectConflict;
}
