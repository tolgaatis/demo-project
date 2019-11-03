package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@Transactional
public class UserService {
	
	 
    @Autowired
	private UserRepository repo;
	     
	    public List<user> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(user user) {
	        repo.save(user);
	    }
	     
	    public user get(long iduser) {
	        return repo.findById(iduser).get();
	    }
	     
	    public void delete(long iduser) {
	        repo.deleteById(iduser);
	    }

	   
	}

