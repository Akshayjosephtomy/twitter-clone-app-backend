package com.nestdigital.twittercloneappbackend.Controller;

import com.nestdigital.twittercloneappbackend.Dao.PostDao;
import com.nestdigital.twittercloneappbackend.Dao.TwitterDao;
import com.nestdigital.twittercloneappbackend.Model.PostModel;
import com.nestdigital.twittercloneappbackend.Model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TwitterController {

    @Autowired
    private TwitterDao dao;

    @Autowired
    private PostDao daop;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/adduser",consumes = "application/json",produces = "application/json")
    private String adduser(@RequestBody TwitterModel user){
        System.out.println(user.toString());
        dao.save(user);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signin",consumes = "application/json",produces = "application/json")
    public List<TwitterModel>signin(@RequestBody TwitterModel signin){
        return (List<TwitterModel>) dao.signin(signin.getEmail(),signin.getPass());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addpost",consumes = "application/json",produces = "application/json")
    private String addpost(@RequestBody PostModel post){
        DateTimeFormatter dt= DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now= LocalDateTime.now();
        String currentdate= String.valueOf(dt.format(now));
        post.setDate(currentdate);

        System.out.println(post.toString());
        daop.save(post);
        return "(status:'success')";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewmypost",consumes = "application/json",produces = "application/json")
    public List<PostModel>viewmypost(@RequestBody PostModel post){
        return (List<PostModel>) daop.myPosts(post.getUserid());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewpost")
    public List<String> viewpost(){
        return (List<String>) daop.viewPost();
    }




}
