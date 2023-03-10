package com.hungpk.threekingdomtactic.payload.request.affinityhero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AffinityHeroUpdateRequest {
    private Long heroId;
    private Long affinityId;
}
