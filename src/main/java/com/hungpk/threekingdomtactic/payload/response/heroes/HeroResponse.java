package com.hungpk.threekingdomtactic.payload.response.heroes;

import com.hungpk.threekingdomtactic.payload.response.tactics.TacticResponse;
import lombok.Data;

@Data
public class HeroResponse {
    private Long id;
    private String name;
    private String nameVn;
    private Integer cost;
    private Integer star;
    private String image;
    private String info;
    private TacticResponse officialTactic;
    private TacticResponse inheritTactic;
}
