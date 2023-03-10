package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "hero")
@Table(name = "hero", schema = AppConfig.SCHEMA)
public class Hero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "name_vn")
	private String nameVn;

	@Column(name = "cost")
	private Integer cost;

	@Column(name = "star")
	private Integer star;

	@Column(name = "image")
	private String image;

	@Column(name = "info")
	private String info;

//	@Column(name = "official_tactic_id")
//	private Long officialTacticId;
//
//	@Column(name = "inherit_tactic_id")
//	private Long inheritTacticId;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "official_tactic_id", nullable = false, insertable = false, updatable = false)
	private Tactic officialTactic;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "inherit_tactic_id", nullable = false, insertable = false, updatable = false)
	private Tactic inheritTactic;

	@ManyToOne(fetch = FetchType.LAZY)
	private Country country;

	@ManyToOne(fetch = FetchType.LAZY)
	private Season season;



}
