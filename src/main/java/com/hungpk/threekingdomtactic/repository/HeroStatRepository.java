package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.enums.StatEnum;
import com.hungpk.threekingdomtactic.model.HeroStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HeroStatRepository extends JpaRepository<HeroStat, Long> {

    List<HeroStat> findByHeroId(Long heroId);

    boolean existsByHeroIdAndStat(Long heroId, StatEnum stat);

    void deleteByHeroId(Long heroId);
}
