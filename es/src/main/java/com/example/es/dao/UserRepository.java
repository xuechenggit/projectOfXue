package com.example.es.dao;

import com.example.es.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<User, String> {

}
