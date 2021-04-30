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
@Entity(name = "affinity_hero")
@Table(name = "affinity_hero", schema = AppConfig.SCHEMA)
public class AffinityHero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "hero_id")
	private Long heroId;

	@Column(name = "affinity_id")
	private Long affinityId;

}
