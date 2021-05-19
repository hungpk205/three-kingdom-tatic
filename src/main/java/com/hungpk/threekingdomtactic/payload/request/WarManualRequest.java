package com.hungpk.threekingdomtactic.payload.request;

import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
public class WarManualRequest {
    private String name;
    private String info;
    private WarManualDto warManual;
}
