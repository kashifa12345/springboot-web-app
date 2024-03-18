package com.realestate.springboot.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;




    public interface UserRepo extends JpaRepository<User, Integer> {


    }


