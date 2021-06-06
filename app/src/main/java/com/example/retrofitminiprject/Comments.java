package com.example.retrofitminiprject;


public class Comments {

    int postId,id;
    String body,name;

    public Comments() {
    }

    public Comments(int postId, int id, String body, String name) {
        this.postId = postId;
        this.id = id;
        this.body = body;
        this.name = name;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
