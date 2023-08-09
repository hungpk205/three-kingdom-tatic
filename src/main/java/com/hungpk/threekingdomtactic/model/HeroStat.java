package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import com.hungpk.threekingdomtactic.enums.StatEnum;
import lombok.Data;

@Data
@Entity(name = "hero_stat")
@Table(name = "hero_stat", schema = AppConfig.SCHEMA)
public class HeroStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "increase")
    private Float increase;

    @Column(name = "base_stat")
    private Integer baseStat;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hero hero;

    @Column(name = "stat")
    @Enumerated(EnumType.STRING)
    private StatEnum stat;

}
