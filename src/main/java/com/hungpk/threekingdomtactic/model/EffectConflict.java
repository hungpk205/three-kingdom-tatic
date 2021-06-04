package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

import java.util.List;

@Data
@Entity(name = "effect_conflict")
@Table(name = "effect_conflict", schema = AppConfig.SCHEMA)
public class EffectConflict {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "info")
    private String info;

    @OneToMany(mappedBy = "effectConflict")
    private List<TacticEffectConflict> tacticEffectConflicts;

}
