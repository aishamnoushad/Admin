package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.Admin.Entity.Categories;


@Repository
public interface CategoryRepository extends JpaRepository<Categories, String>{

}
