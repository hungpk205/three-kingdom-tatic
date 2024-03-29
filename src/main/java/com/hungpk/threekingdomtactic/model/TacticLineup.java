package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "tactic_lineup")
@Table(name = "tactic_lineup", schema = AppConfig.SCHEMA)
public class TacticLineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "lineup_id")
//    private Long lineupId;
//
//    @Column(name = "tactic_id")
//    private Long tacticId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lineup lineup;

    @ManyToOne(fetch = FetchType.LAZY)
    private Tactic tactic;

}
