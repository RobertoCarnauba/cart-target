package com.carnauba.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnauba.entities.User;

public interface UserRepository extends JpaRepository<User, Long>  {

}
