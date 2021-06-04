package com.hungpk.threekingdomtactic.model;

import com.hungpk.threekingdomtactic.config.AppConfig;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "war_manual_effect_conflict")
@Table(name = "war_manual_effect_conflict", schema = AppConfig.SCHEMA)
public class WarManualEffectConflict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "war_manual_id")
    private Long warManualId;

    @Column(name = "effect_conflict_id")
    private Long effectConflictId;
}
