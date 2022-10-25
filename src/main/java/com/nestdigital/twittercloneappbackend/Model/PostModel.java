package com.nestdigital.twittercloneappbackend.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue
    private int id;
    private int userid;
    private String tweet;

    private String date;

    public PostModel() {
    }

    public PostModel(int id, int userid, String tweet, String date) {
        this.id = id;
        this.userid = userid;
        this.tweet = tweet;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

