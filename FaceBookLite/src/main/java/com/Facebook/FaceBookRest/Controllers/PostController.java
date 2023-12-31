package com.Facebook.FaceBookRest.Controllers;

import com.Facebook.FaceBookRest.CustomErrors.NotFoundEntity;
import com.Facebook.FaceBookRest.Models.Comment;
import com.Facebook.FaceBookRest.Models.Post;
import com.Facebook.FaceBookRest.Models.Services.CommentService;
import com.Facebook.FaceBookRest.Models.Services.CommentServicesMemory;
import com.Facebook.FaceBookRest.Models.Services.PostService;
import com.Facebook.FaceBookRest.Models.Services.PostServicesMemory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/posts")
public class PostController {
    @Autowired
    PostService postService = new PostServicesMemory();

    @PostMapping("")
    public Post addPost(@RequestParam int PostID, @RequestParam String title, @RequestParam String description) {
        Post post = new Post(PostID, title, description);
        postService.addPost(post);
        return post;
    }

    @GetMapping("/get/{id}/")
    public Post getPost(@PathVariable int id) throws NotFoundEntity {
        Post post = postService.getPost(id);
        if (post != null) {
            return post;
        } else {
            throw new NotFoundEntity("No Post Create With This ID");
        }
    }

    @DeleteMapping("/delete/{postID}")
    public boolean deletePost(@PathVariable int postID){
        Post post = postService.getPost(postID);
        CommentService commentService = new CommentServicesMemory();
        try {
            List<Comment> comments = commentService.getAllCommentsInPost(postID);
            for (Comment c:comments) {
                commentService.deleteComment(c.getID());
            }
        } catch (NotFoundEntity ignored) {
        }
        if (post != null){
            postService.deletePost(post.getID());
            return true;
        }
        return false;
    }

    @GetMapping("")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
}
