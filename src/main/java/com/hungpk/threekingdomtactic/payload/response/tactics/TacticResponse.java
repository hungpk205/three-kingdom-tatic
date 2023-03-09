package com.hungpk.threekingdomtactic.payload.response.tactics;

import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;
import com.hungpk.threekingdomtactic.enums.TargetTypeEnum;
import com.hungpk.threekingdomtactic.payload.response.effects.EffectResponse;
import lombok.Data;

@Data
public class TacticResponse {
    private Long id;

    private String name;

    private String info;

    private String maxLvInfo;

    private Integer slot;

    private Integer quantity;

    private QualityEnum quality;

    private TacticTypeEnum tacticType;

    private TargetTypeEnum targetType;

    private Long changeToTrigger;

    private EffectResponse effect;

}
