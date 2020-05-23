package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryAnswerEntity;
@Repository
public interface QueryAnswerRepository extends JpaRepository<QueryAnswerEntity, Long>{

	@Query("select c from QueryAnswerEntity c , UserEntity u where u.id = :userId ORDER BY c.createdAt DESC")
    List<QueryAnswerEntity> findQueryAnswerByUserId(@Param("userId") Long userId);
	
	@Query("select c from QueryAnswerEntity c , QueryEntity u where u.id = :queryId ORDER BY c.createdAt DESC")
    List<QueryAnswerEntity> findQueryAnswerByQueryId(@Param("queryId") Long queryId);

}
