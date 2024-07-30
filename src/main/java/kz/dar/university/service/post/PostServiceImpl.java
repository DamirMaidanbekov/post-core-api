package kz.dar.university.service;

import kz.dar.university.entity.PostEntity;
import kz.dar.university.repository.PostRepository;
import kz.dar.university.model.PostModel;
import kz.dar.university.service.deprecated.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void createPost(PostModel postModel) {
        PostEntity postEntity = new PostEntity();
        postEntity.setPostId(UUID.randomUUID().toString());
        postEntity.setClientId(postModel.getClientId());
        postEntity.setPostRecipientId(postModel.getPostRecipientId());
        postEntity.setPostItem(postModel.getPostItem());
        postEntity.setStatus(postModel.getStatus());
        postRepository.save(postEntity);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity -> new PostModel(
                postEntity.getPostId(),
                postEntity.getClientId(),
                postEntity.getPostRecipientId(),
                postEntity.getPostItem(),
                postEntity.getStatus()
        )).collect(Collectors.toList());
    }

    @Override
    public PostModel getPostById(String postId) {
        PostEntity postEntity = postRepository.findByPostId(postId);
        return new PostModel(
                postEntity.getPostId(),
                postEntity.getClientId(),
                postEntity.getPostRecipientId(),
                postEntity.getPostItem(),
                postEntity.getStatus()
        );
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity != null) {
            postEntity.setClientId(postModel.getClientId());
            postEntity.setPostRecipientId(postModel.getPostRecipientId());
            postEntity.setPostItem(postModel.getPostItem());
            postEntity.setStatus(postModel.getStatus());
            postRepository.save(postEntity);
        }
    }

    @Override
    public void deletePostById(String postId) {
        PostEntity postEntity = postRepository.findByPostId(postId);
        if (postEntity != null) {
            postRepository.delete(postEntity);
        }
    }
}
