package com.hungpk.threekingdomtactic.model;

import javax.persistence.*;

import com.hungpk.threekingdomtactic.config.AppConfig;

import com.hungpk.threekingdomtactic.enums.QualityEnum;
import com.hungpk.threekingdomtactic.enums.converter.QualityEnumConverter;
import lombok.Data;

@Data
@Entity(name = "target")
@Table(name = "target", schema = AppConfig.SCHEMA)
public class Target {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity")
	private Integer quantity;
}
