package com.Facebook.FaceBookRest.Services;

import com.Facebook.FaceBookRest.CustomErrors.NotFoundEntity;
import com.Facebook.FaceBookRest.Models.Comment;

import java.util.List;

public interface CommentService {
    boolean addComment(Comment p);

    boolean deleteComment(int id);

    Comment getComment(int id);

    List<Comment> getAllCommentsInPost(int PostID) throws NotFoundEntity;
}
