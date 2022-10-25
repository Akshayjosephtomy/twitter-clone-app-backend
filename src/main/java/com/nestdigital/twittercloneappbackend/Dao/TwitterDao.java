package com.nestdigital.twittercloneappbackend.Dao;

import com.nestdigital.twittercloneappbackend.Model.TwitterModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TwitterDao extends CrudRepository<TwitterModel,Integer>{

    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `pass`, `phone`, `place` FROM `users` WHERE `email`= :email AND `pass`= :pass",nativeQuery = true)
    List<TwitterModel>signin(String email,String pass);
}
