package kz.dar.university.service.deprecated;

import kz.dar.university.model.PostModel;

import java.util.List;

public interface PostServiceOld {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    void updatePostById(String postId, PostModel postModel);
    void deletePostById(String postId);
}
