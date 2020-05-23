package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

}
