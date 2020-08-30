package com.mjx.news.repository;
import org.springframework.data.repository.CrudRepository;
import com.mjx.news.entity.User;
public interface UserRepository extends CrudRepository<User,Integer> {
  
}