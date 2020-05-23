package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryEntity;
@Repository
public interface QueryRepository extends JpaRepository<QueryEntity, Long>{
	@Query("select DISTINCT  c from QueryEntity c join c.userEntity u left  join  c.queryCommentEntities qce left join c.queryAnswerEntities qae  where u.id = :userId ORDER BY c.createdAt DESC")
    List<QueryEntity> findQueryByUserId(@Param("userId") Long userId);
	
	@Query("select  DISTINCT  c from QueryEntity c , QueryTypeEntity u where u.id = :queryTypeId ORDER BY c.createdAt DESC")
    List<QueryEntity> searchQueryListByQueryTypeId(@Param("queryTypeId") Long id);
	
	@Query("select DISTINCT   c from QueryEntity c , QueryTypeEntity u where u.id = :queryTypeId and (c.query like %:name% or c.description like %:name% ) ORDER BY c.createdAt DESC")
    List<QueryEntity> searchQueryListByQueryTypeIdOrName(@Param("queryTypeId") Long id,@Param("name") String name);
	
	@Query("select DISTINCT  c from QueryEntity c join c.userEntity u left  join  c.queryCommentEntities qce left join c.queryAnswerEntities qae ORDER BY c.createdAt DESC")
    List<QueryEntity> findQueryListWithoutUserId();
	
	@Query("select DISTINCT  c from QueryEntity c join c.userEntity u left  join  c.queryCommentEntities qce left join c.queryAnswerEntities qae join c.queryTypeEntity qte   where qte.id = :queryTypeId ORDER BY c.createdAt DESC")
    List<QueryEntity> findQueryDetailListByQueryTypeId(@Param("queryTypeId") Long id);
	
	@Query("select DISTINCT  c from QueryEntity c join c.userEntity u left  join  c.queryCommentEntities qce left join c.queryAnswerEntities qae left join qae.queryReplyAnswerEntities qrae left join qce.queryReplyCommentEntities qrce  where c.id = :id ORDER BY c.createdAt DESC")
    QueryEntity getQueryDetailByQueryId(@Param("id") Long id);
	
}
