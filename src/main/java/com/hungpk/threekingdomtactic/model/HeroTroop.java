package com.hungpk.threekingdomtactic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hungpk.threekingdomtactic.config.AppConfig;
import com.hungpk.threekingdomtactic.enums.QualityEnum;

import lombok.Data;

@Data
@Entity(name = "hero_troop")
@Table(name = "hero_troop", schema = AppConfig.SCHEMA)
public class HeroTroop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "hero_id")
	private Long heroId;

	@Column(name = "troop_id")
	private Long troopId;

	@Column(name = "quality")
	private QualityEnum quality;

}
