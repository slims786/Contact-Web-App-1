package com.contact.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.contact.entity.ContactEntity;

@Transactional
public interface ContactRepository extends JpaRepository<ContactEntity, Integer>{
   
	@Modifying
	@Query(value="update ContactEntity set activeSwitch=:activeSwitch where contactId=:contactId")
	public void softDelete(char activeSwitch, Integer contactId);
}
