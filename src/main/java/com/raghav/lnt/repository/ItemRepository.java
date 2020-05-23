package com.raghav.lnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.ItemEntity;
@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{

}
