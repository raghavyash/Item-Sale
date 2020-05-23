package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.QueryTypeEntity;
@Repository
public interface QueryTypeRepository extends JpaRepository<QueryTypeEntity, Long>{

}
