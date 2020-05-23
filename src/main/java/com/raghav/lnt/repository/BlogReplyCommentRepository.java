package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.BlogReplyCommentEntity;

@Repository
public interface BlogReplyCommentRepository extends JpaRepository<BlogReplyCommentEntity, Long>{

}
