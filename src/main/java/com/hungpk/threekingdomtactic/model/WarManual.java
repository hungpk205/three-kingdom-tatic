package com.hungpk.threekingdomtactic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hungpk.threekingdomtactic.config.AppConfig;

import com.hungpk.threekingdomtactic.dto.EffectDto;
import com.hungpk.threekingdomtactic.dto.TargetDto;
import com.hungpk.threekingdomtactic.dto.WarManualDto;
import lombok.Data;

@Data
@Entity(name = "war_manual")
@Table(name = "war_manual", schema = AppConfig.SCHEMA)
public class WarManual {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "info")
	private String info;

	@Column(name = "war_manual_id")
	private Long warManualId;

	@Column(name = "effect_id")
	private Long effectId;

	@Column(name = "target_id")
	private Long target;

	@Column(name = "change_to_trigger")
	private Double changeToTrigger;
}
