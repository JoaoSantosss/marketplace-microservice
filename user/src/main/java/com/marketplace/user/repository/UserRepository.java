package com.marketplace.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketplace.user.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
