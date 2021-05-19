package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.HeroStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroStatRepository extends JpaRepository<HeroStat, Long> {

    Optional<HeroStat> findByHeroId(Long heroId);

    boolean existsByHeroId(Long heroId);

    void deleteByHeroId(Long heroId);
}
