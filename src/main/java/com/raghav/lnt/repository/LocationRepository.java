package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.LocationEntity;
@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long>{
	@Query("select l from LocationEntity l inner join  l.cityEntity ce  where ce.id = :id")
    List<LocationEntity> findByIdLocation(@Param("id") Long id);
	
	@Query("select l from LocationEntity l inner join  l.cityEntity ce  where ce.cityName = :name")
    List<LocationEntity> findLocationListByCityName(@Param("name") String name);

}
