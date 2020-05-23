package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.BlogCommentEntity;

@Repository
public interface BlogCommentRepository extends JpaRepository<BlogCommentEntity, Long>{
	@Query("select c from BlogCommentEntity c,BlogEntity b  where b.id = :id ORDER BY c.createdAt DESC")
    List<BlogCommentEntity> findBlogCommentByBlogId(@Param("id") Long id);
}
