package com.Facebook.FaceBookRest.Services;

import com.Facebook.FaceBookRest.Models.Post;

import java.util.List;

public interface PostService {
    boolean addPost(Post p);

    boolean deletePost(int id);

    Post getPost(int id);

    List<Post> getAllPosts();
}
