package com.lwp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lwp.model.Contact;
import com.lwp.repo.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo contactRepo;
	
	public Contact createNewContact(Contact contact) {
		return contactRepo.save(contact);
	}
	
	public List<Contact> getAllContacts() {
		return contactRepo.findAll();
	}
	
	public String activateDeactivateLoc(int id) {
		Contact contact = contactRepo.findById(id).isPresent() ? contactRepo.findById(id).get() : null;
		if(contact.isActive() == true) {
			contact.setActive(false);
			contactRepo.save(contact);
			return "deactive";
		}else {
			contact.setActive(true);
			contactRepo.save(contact);
			return "active";
		}
		
	}
	
	public String deleteContact(int id) {
		contactRepo.deleteById(id);
		return "success";
	}

}
