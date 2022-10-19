package com.solog.api.controller;

import com.solog.api.service.PostService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.solog.api.request.PostDto.PostCreate;
import static com.solog.api.response.ApiResponse.success;

@Slf4j
@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<?> post(@RequestBody @Valid PostCreate postCreate) {

        postService.createPost(postCreate);

        return success();
    }

}
