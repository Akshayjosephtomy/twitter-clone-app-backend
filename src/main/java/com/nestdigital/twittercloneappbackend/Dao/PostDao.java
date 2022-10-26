package com.nestdigital.twittercloneappbackend.Dao;

import com.nestdigital.twittercloneappbackend.Model.PostModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostDao extends CrudRepository<PostModel,Integer> {


    @Query(value = "SELECT p.id, p.`date`, p.`tweet`, p.`userid`,u.name FROM `posts` p JOIN users u ON p.userid=u.id where userid= :userid",nativeQuery = true)
    List<Map<String,String>> myPosts(Integer userid);

    @Query(value = "SELECT p.id, p.`date`, p.`tweet`, p.`userid`,u.name FROM `posts` p JOIN users u ON p.userid=u.id",nativeQuery = true)
    List<Map<String,String>> viewPost();

    @Modifying
    @Query(value = "DELETE FROM `posts` WHERE `id`= :id",nativeQuery = true)
    void deletePost(Integer id);
}
