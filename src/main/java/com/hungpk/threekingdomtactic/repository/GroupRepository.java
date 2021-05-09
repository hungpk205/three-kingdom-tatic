package com.hungpk.threekingdomtactic.repository;

import com.hungpk.threekingdomtactic.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

}
