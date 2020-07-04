package com.simpragma.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simpragma.management.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserIdAndUserName(int userId, String userName);
}
