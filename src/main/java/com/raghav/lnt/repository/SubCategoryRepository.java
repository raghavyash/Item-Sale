package com.raghav.lnt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.SubCategoryEntity;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategoryEntity, Long>{
	@Query("select l from SubCategoryEntity l inner join  l.categoryEntity ce  where ce.id = :id")
    List<SubCategoryEntity> findByIdSubCategory(@Param("id") Long id);

}
