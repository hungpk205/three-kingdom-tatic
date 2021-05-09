package com.hungpk.threekingdomtactic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungpk.threekingdomtactic.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
