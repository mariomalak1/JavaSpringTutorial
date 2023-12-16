package com.Facebook.FaceBookRest.Models;

import com.Facebook.FaceBookRest.Controllers.CommentController;

public class Comment {
    int ID;
    String Content;
    Post post;
    int PostID;

    public Comment(int ID, String content, Post post, int postID) {
        this.ID = ID;
        Content = content;
        this.post = post;
        PostID = postID;
    }

    public Comment(){
        ID = 0;
        Content = "No Content";
        post = null;
        PostID = 0;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public com.Facebook.FaceBookRest.Models.Post getPost() {
        return post;
    }

    public void setPost(com.Facebook.FaceBookRest.Models.Post p) {
        post = p;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }
}
