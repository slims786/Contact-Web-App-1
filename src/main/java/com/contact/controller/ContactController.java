package com.contact.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.contact.constant.AppConstant;
import com.contact.model.ContactModel;
import com.contact.service.ContactService;

@Controller
public class ContactController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	
   
	@Autowired
	private ContactService service;
	
	@RequestMapping(value = "/displayForm")
	
	public String init(Model model) {
		System.out.println("Init method started");
		logger.debug(AppConstant.Method_Started_str);
		ContactModel contact = new ContactModel();
		model.addAttribute(AppConstant.Contact_str, contact);
		logger.info(AppConstant.Method_ended_str);
		System.out.println("Init method ended");
		return  AppConstant.Contact_str;
	}
	
	@RequestMapping(value ="/addContact", method= RequestMethod.POST)
	public String saveContact(@ModelAttribute(AppConstant.Contact_str)ContactModel contact,Model model) {
	logger.debug(AppConstant.Method_Started_str);
	boolean saveContact = service.saveContact(contact);	
	if(saveContact) {
		model.addAttribute(AppConstant.success_str,"Contact Added Successfully");
	  logger.info("contact is added");
	}
	else {
		model.addAttribute(AppConstant.failed_str, "Contact failed to add");
		logger.info("contact is not added");
	}
	logger.debug(AppConstant.Method_ended_str );
	 return  AppConstant.Contact_str;
	}
	
	@RequestMapping(value="/viewActiveContacts")
	public String getContactWithActiveSwith(Model model) {
		logger.debug(AppConstant.Method_Started_str);
		List<ContactModel> contactlist = service.getAllActiveContacts();
		model.addAttribute("contacts",contactlist);
		logger.debug(AppConstant.Method_ended_str);
		logger.info("all contacts are retrieved");
		return AppConstant.View_Contact_str;
	}
	
	@RequestMapping(value="/editContact")
	public String getEditWithLink(HttpServletRequest req,Model model) {
		logger.debug(AppConstant.Method_Started_str);
		Integer cid = Integer.parseInt(req.getParameter(AppConstant.Cid_str));
		ContactModel contactWithId = service.findContactById(cid);
		model.addAttribute(AppConstant.Contact_str, contactWithId);
		logger.debug(AppConstant.Method_ended_str );
		logger.info("method edited");
		return  AppConstant.Contact_str;
	}
	
	@RequestMapping(value="/deleteContact")
	public String deleteWithLink(HttpServletRequest req,RedirectAttributes ra) {
		logger.debug(AppConstant.Method_Started_str);
		Integer cid = Integer.parseInt(req.getParameter(AppConstant.Cid_str));
		boolean isdelete = service.deleteContact(cid);
		if(isdelete) {
			ra.addFlashAttribute(AppConstant.delete_str, "Contact deleted successfully");
			logger.info("contact is deleted");
		}
		logger.debug(AppConstant.Method_ended_str);
		logger.info("contact deleted");
		return AppConstant.View_Contact_redirect;
	}
}
