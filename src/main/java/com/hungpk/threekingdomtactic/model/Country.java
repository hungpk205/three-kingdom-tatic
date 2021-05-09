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
@Entity(name = "country")
@Table(name = "country", schema = AppConfig.SCHEMA)
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "name_vn")
	private String nameVn;

}
