package com.solog.api.controller;

import com.solog.api.request.PostDto;
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
    public ResponseEntity<?> post(@RequestBody @Valid PostDto.PostCreateRequest postCreateRequest) {
        log.info("postCreate = {}", postCreateRequest);

        return ResponseEntity.ok().build();
    }

}
