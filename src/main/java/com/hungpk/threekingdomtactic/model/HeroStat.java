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
@Entity(name = "hero_stat")
@Table(name = "hero_stat", schema = AppConfig.SCHEMA)
public class HeroStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "hero_id")
    private Long heroId;

    @Column(name = "statId")
    private Long statId;

    @Column(name = "quality")
    private Float gaint;

}
