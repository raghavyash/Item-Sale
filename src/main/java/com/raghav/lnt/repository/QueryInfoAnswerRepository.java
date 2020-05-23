package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryInfoAnswerEntity;
@Repository
public interface QueryInfoAnswerRepository extends JpaRepository<QueryInfoAnswerEntity, Long>{

}
