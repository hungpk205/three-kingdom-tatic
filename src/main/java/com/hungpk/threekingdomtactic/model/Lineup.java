package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "lineup")
@Table(name = "lineup", schema = AppConfig.SCHEMA)
public class Lineup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "hero_id")
//    private Long heroId;
//
//    @Column(name = "group_id")
//    private Long groupId;

    @Column(name = "is_commander")
    private Boolean isCommander;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

}
