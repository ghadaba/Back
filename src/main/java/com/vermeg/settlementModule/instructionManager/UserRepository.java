package com.vermeg.settlementModule.instructionManager;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vermeg.settlementModule.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
