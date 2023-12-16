package com.Facebook.FaceBookRest.Controllers;

import com.Facebook.FaceBookRest.CustomErrors.NotFoundEntity;
import com.Facebook.FaceBookRest.Models.Comment;
import com.Facebook.FaceBookRest.Models.Post;
import com.Facebook.FaceBookRest.Models.Response;
import com.Facebook.FaceBookRest.Models.Services.CommentService;
import com.Facebook.FaceBookRest.Models.Services.CommentServicesMemory;
import com.Facebook.FaceBookRest.Models.Services.PostService;
import com.Facebook.FaceBookRest.Models.Services.PostServicesMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments/")
public class CommentController {

    @Autowired
    final CommentService commentService = new CommentServicesMemory();
    final PostService postService = new PostServicesMemory();

    @PostMapping("")
    public Response addComment(@RequestParam int commentID, @RequestParam String content, @RequestParam int postID) throws NotFoundEntity {
        Response response = new Response();
        Post post = postService.getPost(postID);
        if (post != null) {
            Comment comment = new Comment(commentID, content, post, postID);
            commentService.addComment(comment);
            response.setMessage(comment.toString());
            response.setStatus(true);
            return response;
        } else {
            throw new NotFoundEntity("No Post Create With This ID");
        }
    }

    @GetMapping("/get/{id}/")
    public Response getComment(int commentID) throws NotFoundEntity {
        Comment comment = commentService.getComment(commentID);
        if (comment != null) {
            Response response = new Response();
            response.setMessage(comment.toString());
            response.setStatus(true);
            return response;
        } else {
            throw new NotFoundEntity("No Post Create With This ID");
        }
    }

}