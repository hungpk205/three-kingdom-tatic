package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "replacement_officer")
@Table(name = "replacement_officer", schema = AppConfig.SCHEMA)
public class ReplacementOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "lineup_id")
//    private Long lineupId;
//
//    @Column(name = "hero_id")
//    private Long heroId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lineup lineup;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

}
