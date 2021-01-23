package com.springdb.mysql.springbootmysql.repository;

import com.springdb.mysql.springbootmysql.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<Users,Integer> {

    Users findByName(String name);
}
