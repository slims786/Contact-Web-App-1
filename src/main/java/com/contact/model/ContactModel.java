package com.contact.model;

import lombok.Data;

@Data
public class ContactModel {
   private Integer contactId;
   private String contactName;
   private String contactEmail;
   private Long contactNumber;
   private char activeSwitch;
}
