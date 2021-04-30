package com.hungpk.threekingdomtactic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hungpk.threekingdomtactic.config.AppConfig;
import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.TacticTypeEnum;

import lombok.Data;

@Data
@Entity(name = "tactic")
@Table(name = "tactic", schema = AppConfig.SCHEMA)
public class Tactic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "effect_id")
	private Long effectId;

	@Column(name = "target_id")
	private Long targetId;

	@Column(name = "name")
	private String name;

	@Column(name = "info")
	private String info;

	@Column(name = "max_lv_info")
	private String maxLvInfo;

	@Column(name = "quality")
	private QualityEnum quality;

	@Column(name = "type")
	private TacticTypeEnum type;

	@Column(name = "change_to_trigger")
	private Long changeToTrigger;
}
