package com.vermeg.settlementModule.instructionManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vermeg.settlementModule.model.User;

public class UserService {
	@Autowired
	private UserRepository repo ;

	public List<User> ListAll() {
		return repo.findAll();
	}
	 public void save(User user) {
		 repo.save(user);
		 
		 
	 }
	 public User get (Long id ) {
		 return repo.findById(id).get();
	 }
	 public void delete(long id) {
		 repo.deleteById(id);
	 }

}
