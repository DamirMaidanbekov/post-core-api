package kz.dar.university.controller;

import java.util.List;
import jakarta.validation.Valid;
import kz.dar.university.model.PostModel;
import kz.dar.university.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel){
        postService.createPost(postModel);
        return new ResponseEntity<>("Принято!", HttpStatus.OK);
    }

    @GetMapping("/check")
    public ResponseEntity<String> checkWork(){
        return new ResponseEntity<>("post-core-api is working", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts(){
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @Valid @RequestBody PostModel postModel){
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<>("Изменено!", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId){
        postService.deletePostById(postId);
        return new ResponseEntity<>("Удалено!", HttpStatus.OK);
    }
}
