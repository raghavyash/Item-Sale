package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.BlogEntity;
import com.raghav.lnt.entity.QueryEntity;
import com.raghav.lnt.entity.SaleEntity;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity, Long>{
	@Query("select c from BlogEntity c join c.userEntity u where u.id = :userId ORDER BY c.createdAt DESC")
    List<BlogEntity> findBlogByUserId(@Param("userId") Long userId);
	
	@Query("select c from BlogEntity c join c.blogTypeEntity u where u.id = :blogTypeId and (c.title like %:name% ) ORDER BY c.createdAt DESC ")
    List<BlogEntity> searchBlogListByIdWithName(@Param("blogTypeId") Long id,@Param("name") String name);
	
	@Query("select c from BlogEntity c join c.blogTypeEntity u where u.id = :blogTypeId ORDER BY c.createdAt DESC")
    List<BlogEntity> searchBlogListById(@Param("blogTypeId") Long id);
	
	@Query("select DISTINCT  c from BlogEntity c join c.userEntity u left  join  c.blogCommentEntities qce ORDER BY c.createdAt DESC ")
    List<BlogEntity> findBlogListWithoutUserId();
	
	@Query("select DISTINCT  c from BlogEntity c join c.userEntity u left  join  c.blogCommentEntities qce join c.blogTypeEntity bte where bte.id=:blogTypeId ORDER BY c.createdAt DESC ")
    List<BlogEntity> getBlogDetailListByBlogTypeId(@Param("blogTypeId") Long id);
	
	@Query("select DISTINCT  c from BlogEntity c join c.userEntity u left  join  c.blogCommentEntities qce left join qce.blogReplyCommentEntities brc where c.id = :id ORDER BY qce.createdAt  ")
    BlogEntity getBlogDetailByBlogId(@Param("id") Long id);
}
