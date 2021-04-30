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
@Entity(name = "recommended_war_manual")
@Table(name = "recommended_war_manual", schema = AppConfig.SCHEMA)
public class RecommendedWarManual {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "hero_id")
	private Long heroId;

	@Column(name = "war_manual_id")
	private Long warManualId;

}
