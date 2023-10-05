package com.lwp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lwp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
