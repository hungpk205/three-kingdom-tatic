package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "recommended_tactic")
@Table(name = "recommended_tactic", schema = AppConfig.SCHEMA)
public class RecommendedTactic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

//	@Column(name = "hero_id")
//	private Long heroId;
//
//	@Column(name = "tactic_id")
//	private Long tacticId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Hero hero;

	@ManyToOne(fetch = FetchType.LAZY)
	private Tactic tactic;

}
