package com.yeolmok.aidataaccess.user.repository;

import com.yeolmok.aidataaccess.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
