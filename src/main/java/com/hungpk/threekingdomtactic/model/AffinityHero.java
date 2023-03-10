package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "affinity_hero")
@Table(name = "affinity_hero", schema = AppConfig.SCHEMA)
public class AffinityHero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Affinity affinity;

}
