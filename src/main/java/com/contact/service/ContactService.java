package com.contact.service;

import java.util.List;

import com.contact.model.ContactModel;

public interface ContactService {
      public boolean saveContact(ContactModel contact);
      public List<ContactModel> getAllActiveContacts();
      public ContactModel findContactById(Integer contactId);
      public boolean deleteContact(Integer contactId);
}
