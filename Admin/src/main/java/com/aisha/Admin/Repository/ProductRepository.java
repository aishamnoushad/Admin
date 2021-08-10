package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.Admin.Entity.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
