package com.Facebook.FaceBookRest.Models.Services;

import com.Facebook.FaceBookRest.CustomErrors.NotFoundEntity;
import com.Facebook.FaceBookRest.Models.Comment;
import com.Facebook.FaceBookRest.Models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommentServicesMemory implements CommentService{
    @Override
    public boolean addComment(Comment c) {
        if (Common.Comments.get(c.getID()) == null){
            Common.Comments.put(c.getID(), c);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteComment(int id) {
        Comment Comment = Common.Comments.get(id);
        if (Comment != null){
            Common.Comments.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Comment getComment(int id) {
        return Common.Comments.get(id);
    }

    @Override
    public List<Comment> getAllCommentsInPost(int postID) throws NotFoundEntity {
        ArrayList<Comment> comments = new ArrayList<>();
        PostServicesMemory postServicesMemory = new PostServicesMemory();
        Post post = postServicesMemory.getPost(postID);
        if (post != null){
            Set<Integer> commentsIDs = Common.Comments.keySet();
            for (Integer id: commentsIDs) {
                Comment comment = Common.Comments.get(id);
                if (comment.getPostID() == postID){
                    comments.add(comment);
                }
            }
        }else{
            throw new NotFoundEntity("Not Found That Post");
        }
        return comments;
    }
}
