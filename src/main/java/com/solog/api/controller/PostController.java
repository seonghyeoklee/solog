package com.solog.api.controller;

import static com.solog.api.request.PostDto.PostCreate;
import static com.solog.api.response.ApiResponse.success;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class PostController {

    @PostMapping("/posts")
    public ResponseEntity<?> post(@RequestBody @Valid PostCreate postCreate) {
        log.info("postCreate = {}", postCreate);

        return success();
    }

}
