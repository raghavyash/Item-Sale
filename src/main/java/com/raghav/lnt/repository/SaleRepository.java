package com.raghav.lnt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.raghav.lnt.entity.SaleEntity;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, Long>{
	
	@Query("select c from SaleEntity c ORDER BY c.createdAt DESC")
    List<SaleEntity> searchSaleWithDefault();
	
	@Query("select c from SaleEntity c  join c.userEntity u where u.id = :userId ORDER BY c.createdAt DESC")
    List<SaleEntity> findSaleByUserId(@Param("userId") Long userId);
	
	 @Query("select c from SaleEntity c   where c.cityName = :cityName")
     List<SaleEntity> searchSaleWithCity(@Param("cityName") String cityName);
	 
	 @Query("select c from SaleEntity c   where c.cityName = :cityName and c.locationName = :locationName ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCityLocation(@Param("cityName") String cityName,@Param("locationName") String locationName);
	 
	 @Query("select c from SaleEntity c join c.categoryEntity u where u.id = :id ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCatId(@Param("id") Long id);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s where u.id = :catId and s.id=:subCatId ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCatIdWithSubCatId(@Param("catId") Long catId,@Param("subCatId") Long subCatId);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s join c.itemEntity i where u.id = :catId and s.id=:subCatId and i.id=:itemId ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCatIdWithSubCatIdWithItem(@Param("catId") Long catId,@Param("subCatId") Long subCatId,@Param("itemId") Long itemId);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u where u.id = :catId and  c.cityName = :cityName and c.locationName = :locationName  ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCatIdWithCityLocation(@Param("cityName") String cityName,@Param("locationName") String locationName,@Param("catId") Long catId);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s where u.id = :catId and s.id=:subCatId and  c.cityName = :cityName and c.locationName = :locationName ORDER BY c.createdAt DESC ")
	 List<SaleEntity> searchSaleWithCatIdWithSubCatIdCityLocation(@Param("cityName") String cityName,@Param("locationName") String locationName,@Param("catId") Long catId,@Param("subCatId") Long subCatId);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s join c.itemEntity i where u.id = :catId and s.id=:subCatId and i.id=:itemId and  c.cityName = :cityName and c.locationName = :locationName  ORDER BY c.createdAt DESC")
	 List<SaleEntity> searchSaleWithCatIdWithSubCatIdWithItemCityLocation(@Param("cityName") String cityName,@Param("locationName") String  locationName, @Param("catId") Long catId,@Param("subCatId") Long subCatId,@Param("itemId") Long itemId);
	 
	 @Query("select c from SaleEntity c join  c.categoryEntity u join c.subCategoryEntity s join c.itemEntity i where i.id = :itemId ORDER BY c.createdAt DESC")
	 List<SaleEntity> getSaleDetailListByItemId(@Param("itemId") Long itemId);
	 
	 @Query("select c from SaleEntity c  where c.id = :id ORDER BY c.createdAt DESC")
	 List<SaleEntity> findUploadImagesBySaleId(@Param("id") Long id);
		 
}
