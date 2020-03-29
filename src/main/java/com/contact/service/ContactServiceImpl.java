package com.contact.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.entity.ContactEntity;
import com.contact.model.ContactModel;
import com.contact.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
	@Autowired
	private ContactRepository repository;

	@Override
	public boolean saveContact(ContactModel contact) {
		logger.debug("method started");
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(contact, entity);
		entity.setActiveSwitch('Y');
		ContactEntity save = repository.save(entity);
		logger.info("contact is saved");
		return save.getContactId()!=null;
	}

	@Override
	public List<ContactModel> getAllActiveContacts() {
		logger.debug("method started");
		List<ContactEntity> allentity = repository.findAll();
		//filter entity objects based of active switch
		List<ContactEntity> filterList = allentity.stream().filter(entity->entity.getActiveSwitch()==('Y')).
				                                          collect(Collectors.toList());
		//create Model list object
		List<ContactModel> modellist = new ArrayList<ContactModel>();
		//copy properties from entity to model
		for(ContactEntity entity : filterList) {
			ContactModel model = new ContactModel();
			BeanUtils.copyProperties(entity, model);
			modellist.add(model);
		}
		logger.info("all contact retrived with active status");
		return modellist;
	}

	@Override
	public ContactModel findContactById(Integer contactId) {
		logger.debug("method started");
		Optional<ContactEntity> optionalModel = repository.findById(contactId);
		if(optionalModel.isPresent()) {
			ContactEntity contactEntity = optionalModel.get();
			ContactModel model = new ContactModel();
			BeanUtils.copyProperties(contactEntity, model);
			logger.info("contact is retrived based on Id");
			return model;
		}
		return null;
	}

	@Override
	public boolean deleteContact(Integer contactId) {
		logger.debug("method started");
		 repository.softDelete('N', contactId);
		 logger.info("contact is softdeleted");
		return true;
	}
}
