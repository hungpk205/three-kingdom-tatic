package com.hungpk.threekingdomtactic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "tactic_apply")
@Table(name = "tactic_apply", schema = AppConfig.SCHEMA)
public class TacticApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tactic_id")
    private Long tacticId;

    @Column(name = "troop_id")
    private Long troopId;

}
