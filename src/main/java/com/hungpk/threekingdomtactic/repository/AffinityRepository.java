package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Affinity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffinityRepository extends JpaRepository<Affinity, Long> {

}
