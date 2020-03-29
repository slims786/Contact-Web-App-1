package com.contact.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="CONTACT_MASTER1")
public class ContactEntity {
	@Id
	@Column(name= "CONTACT_ID")
	@GeneratedValue
  private Integer contactId;
	@Column(name= "CONTACT_NAME")
  private String contactName;
	@Column(name= "CONTACT_EMAIL")
  private String contactEmail;
	@Column(name= "CONTACT_NUMBER")
  private Long contactNumber;
	@Column(name= "ACTIVE_SWITCH")
  private char activeSwitch;
	@Column(name= "CREATED_DATE", updatable= false)
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
  private Date createDate;
	@Column(name="UPDATED_DATE", insertable= false)
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	private Date updateDate;
}
