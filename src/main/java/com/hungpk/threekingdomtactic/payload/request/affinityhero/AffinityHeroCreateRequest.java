package com.hungpk.threekingdomtactic.payload.request.affinityhero;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AffinityHeroCreateRequest {
    private List<Long> hero;
    private Long affinityId;
}
