package com.sample.app.controller;

import com.sample.app.controller.req.CreatePostReq;
import com.sample.app.controller.res.PostRes;
import com.sample.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @PostMapping("/posts")
    public ResponseEntity<Void> createPost(@RequestBody final CreatePostReq req) throws Exception {

        postService.createPost(req.getPostContent());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @GetMapping("/posts/{postSeq}")
    public ResponseEntity<PostRes> findPostById(@PathVariable final Long postSeq) throws Exception {

        return ResponseEntity.ok(PostRes.ofDto(postService.findPostByPostId(postSeq)));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostRes>> findAllPosts() throws Exception{

        return ResponseEntity.ok().body(postService.findAllPost().stream().map(PostRes::ofDto)
                .collect(Collectors.toList()));
    }
}
