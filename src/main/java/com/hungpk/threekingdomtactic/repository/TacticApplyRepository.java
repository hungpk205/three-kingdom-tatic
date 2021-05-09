package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.TacticApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacticApplyRepository extends JpaRepository<TacticApply, Long> {

}
