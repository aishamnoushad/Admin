package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.Admin.Entity.SubCategory;
import com.aisha.Admin.Entity.SubCategoryIdentity;



@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, SubCategoryIdentity>{

}
