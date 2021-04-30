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

	@Column(name = "offical_tactic_id")
	private Long officalTacticId;

	@Column(name = "inherit_tactic_id")
	private Long inheritTacticId;
}
