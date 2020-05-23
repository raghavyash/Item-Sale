package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.FeedBackEntity;
@Repository
public interface FeedBackRepository extends JpaRepository<FeedBackEntity, Long>{

}
