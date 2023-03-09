package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.HeroStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroStatRepository extends JpaRepository<HeroStat, Long> {

    List<HeroStat> findByHeroId(Long heroId);

    boolean existsByHeroIdAndStatId(Long heroId, Long statId);

    void deleteByHeroId(Long heroId);
}
