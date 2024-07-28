package kz.dar.university.service;

import jakarta.validation.Valid;
import kz.dar.university.model.PostModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PostService {
    void createPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    void updatePostById(String postId, PostModel postModel);
    void deletePostById(String postId);
}
