package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Effect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EffectRepository extends JpaRepository<Effect, Long> {

}
