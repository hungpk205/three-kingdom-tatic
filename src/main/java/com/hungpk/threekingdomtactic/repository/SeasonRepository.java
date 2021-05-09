package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

}
