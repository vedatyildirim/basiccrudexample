package com.vedatyildirim.basiccrudexample.controller;

import com.vedatyildirim.basiccrudexample.domain.Post;
import com.vedatyildirim.basiccrudexample.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.Long;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Api(value="post", description=" Post Operations Service")
public class PostController {

    @Autowired
    private PostService postService;

    private static final Logger log = LoggerFactory.getLogger(PostController.class);


    @ApiOperation(value = "View a list of available posts",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping("/")
    public ResponseEntity<Iterable<Post>> getAll() {
        return ResponseEntity.ok(postService.findAll());
    }


    @ApiOperation(value = "Search a post with an ID",response = Post.class)
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        Optional<Post> post = postService.findById(id);
        if (!post.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(post.get());
    }


    @ApiOperation(value = "Add a post")
    @PostMapping("/")
    public ResponseEntity create(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }


    @ApiOperation(value = "Update a post")
    @PutMapping("/{id}")
    public ResponseEntity<Post> update(@PathVariable Long id, @Valid @RequestBody Post post) {
        if (!postService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(postService.save(post));
    }


    @ApiOperation(value = "Delete a post")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!postService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        postService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}