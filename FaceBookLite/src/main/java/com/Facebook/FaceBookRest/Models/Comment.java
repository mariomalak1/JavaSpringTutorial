package com.Facebook.FaceBookRest.Models;

public class Comment {
    int ID;
    String Content;
    Post Post;
    int PostID;


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
        return Post;
    }

    public void setPost(com.Facebook.FaceBookRest.Models.Post post) {
        Post = post;
    }

    public int getPostID() {
        return PostID;
    }

    public void setPostID(int postID) {
        PostID = postID;
    }
}
