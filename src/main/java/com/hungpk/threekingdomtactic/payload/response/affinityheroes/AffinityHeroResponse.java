package com.hungpk.threekingdomtactic.payload.response.affinityheroes;

import com.hungpk.threekingdomtactic.payload.response.affinities.AffinityResponse;
import com.hungpk.threekingdomtactic.payload.response.heroes.HeroResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AffinityHeroResponse {
    private String id;
    private HeroResponse hero;
    private AffinityResponse affinity;

    @Getter
    @Setter
    private static class HeroResponse {
        private Long id;
        private String name;
    }
}
