package com.Facebook.FaceBookRest.Models.Services;

import com.Facebook.FaceBookRest.Models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PostServicesMemory implements PostService{
    @Override
    public boolean addPost(Post p) {
        if (Common.Posts.get(p.getID()) == null){
            Common.Posts.put(p.getID(), p);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(int id) {
        Post Post = Common.Posts.get(id);
        if (Post != null){
            Common.Posts.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Post getPost(int id) {
        return Common.Posts.get(id);
    }

    @Override
    public List<Post> getAllPosts() {
        ArrayList<Post> posts = new ArrayList<>();
        Set<Integer> ids = Common.Posts.keySet();
        for (Integer id: ids) {
            posts.add(Common.Posts.get(id));
        }
        return posts;
    }
}
