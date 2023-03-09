package com.hungpk.threekingdomtactic.model;

import com.hungpk.threekingdomtactic.config.AppConfig;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "war_manual_apply")
@Table(name = "war_manual_apply", schema = AppConfig.SCHEMA)
public class WarManualApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "war_manual_id")
//    private Long warManualId;
//
//    @Column(name = "troop_id")
//    private Long troopId;

    @ManyToOne(fetch = FetchType.LAZY)
    private WarManual warManual;

    @ManyToOne(fetch = FetchType.LAZY)
    private Troop troop;
}
