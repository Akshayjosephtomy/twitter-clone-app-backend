package com.nestdigital.twittercloneappbackend.Dao;

import com.nestdigital.twittercloneappbackend.Model.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostDao extends CrudRepository<PostModel,Integer> {


    @Query(value = "select * from posts where userid= :userid",nativeQuery = true)
    List<PostModel> myPosts(Integer userid);

    @Query(value = "SELECT p.`date`, p.`tweet`, p.`userid`,u.name FROM `posts` p JOIN users u ON p.userid=u.id",nativeQuery = true)
    List<String> viewPost();
}
