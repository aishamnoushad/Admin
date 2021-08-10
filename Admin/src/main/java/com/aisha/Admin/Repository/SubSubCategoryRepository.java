package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.Admin.Entity.SubSubCategory;
import com.aisha.Admin.Entity.SubSubCategoryIdentity;
@Repository
public interface SubSubCategoryRepository extends JpaRepository<SubSubCategory, SubSubCategoryIdentity> {

}
