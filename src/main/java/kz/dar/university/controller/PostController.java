package kz.dar.university.controller;

import java.util.List;
import jakarta.validation.Valid;
import kz.dar.university.model.PostModel;
import kz.dar.university.service.deprecated.PostServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    Environment env;

    @Autowired
    private PostServiceOld postServiceOld;

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostModel postModel){
        postServiceOld.createPost(postModel);
        return new ResponseEntity<>("Принято!", HttpStatus.OK);
    }

    @GetMapping("/check")
    public String checkWork(){
        return "post-core-api is working at " + env.getProperty("local.server.port");
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts(){
        return postServiceOld.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getPostById(@PathVariable String postId){
        return postServiceOld.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> updatePostById(@PathVariable String postId, @Valid @RequestBody PostModel postModel){
        postServiceOld.updatePostById(postId, postModel);
        return new ResponseEntity<>("Изменено!", HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePostById(@PathVariable String postId){
        postServiceOld.deletePostById(postId);
        return new ResponseEntity<>("Удалено!", HttpStatus.OK);
    }
}
