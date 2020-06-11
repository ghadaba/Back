package com.vermeg.settlementModule.instructionManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.vermeg.settlementModule.model.User;

public class UserController {
	@Autowired
	private UserRepository UserRepository;

	@GetMapping("/users")
	public List<com.vermeg.settlementModule.model.User> getAllUsers() {
		return UserRepository.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<com.vermeg.settlementModule.model.User> getUserById(
			@PathVariable(value = "id") Long userId) throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.User user = UserRepository.findById(userId)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id :: " + userId));
		return ResponseEntity.ok().body(user);
	}

	@PostMapping("/user")
	public User createUser (@Valid @RequestBody User user) {
		return UserRepository.save(user);
	}

	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
			@Valid @RequestBody com.vermeg.settlementModule.model.User UserDetails)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.User user = UserRepository.findById(userId)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id :: " + userId));
		
		user.setId(UserDetails.getId());
		user.setNom(UserDetails.getNom());
		user.setPrenom(UserDetails.getPrenom());

		final com.vermeg.settlementModule.model.User updatedUser = UserRepository
				.save(user);
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/transactions/{Id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "Id") Long userId)
			throws RessourceNotFoundException {
		com.vermeg.settlementModule.model.User user = UserRepository.findById(userId)
				.orElseThrow(
						() -> new RessourceNotFoundException("user not found for this id :: " + userId));

		UserRepository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
