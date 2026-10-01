
package com.jobconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobconnect.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmailAndPassword(String email, String password);

}