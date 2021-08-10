package com.aisha.Admin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aisha.Admin.Entity.WhatsappClickClass;


@Repository
public interface whatsappClickRepository extends JpaRepository<WhatsappClickClass, Integer> {

	
		
}
