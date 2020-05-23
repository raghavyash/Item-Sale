package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryReplyCommentEntity;

@Repository
public interface QueryReplyCommentRepository extends JpaRepository<QueryReplyCommentEntity, Long>{

}
