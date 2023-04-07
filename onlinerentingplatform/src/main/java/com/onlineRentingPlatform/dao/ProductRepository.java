package com.onlineRentingPlatform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.onlineRentingPlatform.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	@Query("from Product as c where c.user.df =df")
	public List<Product> findProductsByUser(@Param("df")int df);
}
