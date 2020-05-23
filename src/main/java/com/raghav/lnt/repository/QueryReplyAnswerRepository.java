package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryReplyAnswerEntity;

@Repository
public interface QueryReplyAnswerRepository extends JpaRepository<QueryReplyAnswerEntity, Long>{

}
