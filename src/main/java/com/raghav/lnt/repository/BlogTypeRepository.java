package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.BlogTypeEntity;
@Repository
public interface BlogTypeRepository extends JpaRepository<BlogTypeEntity, Long>{

}
