package com.nestdigital.twittercloneappbackend.Controller;

import com.nestdigital.twittercloneappbackend.Dao.PostDao;
import com.nestdigital.twittercloneappbackend.Dao.TwitterDao;
import com.nestdigital.twittercloneappbackend.Model.PostModel;
import com.nestdigital.twittercloneappbackend.Model.TwitterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

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
    public List<Map<String,String>>viewmypost(@RequestBody PostModel post){
        return (List<Map<String,String>>) daop.myPosts(post.getUserid());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewpost")
    public List<Map<String,String>> viewpost(){
        return (List<Map<String,String>>) daop.viewPost();
    }

    @CrossOrigin(origins = "*")
    @Transactional
    @PostMapping(path = "/deletepost",consumes = "application/json",produces = "application/json")
    public String deletepost(@RequestBody PostModel post){
        daop.deletePost(post.getId());
        return "(status:'success')";
    }




}
