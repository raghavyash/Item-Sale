package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryCommentEntity;
@Repository
public interface QueryCommentRepository extends JpaRepository<QueryCommentEntity, Long>{
	@Query("select c from QueryCommentEntity c,QueryEntity b  where b.id = :id ORDER BY c.createdAt DESC")
    List<QueryCommentEntity> findQueryCommentByQueryId(@Param("id") Long id);
}
