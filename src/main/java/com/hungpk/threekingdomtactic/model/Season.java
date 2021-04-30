package com.hungpk.threekingdomtactic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hungpk.threekingdomtactic.config.AppConfig;

import lombok.Data;

@Data
@Entity(name = "season")
@Table(name = "season", schema = AppConfig.SCHEMA)
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
}
