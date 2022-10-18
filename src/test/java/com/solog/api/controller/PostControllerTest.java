package com.solog.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solog.api.request.PostDto.PostCreate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@AutoConfigureRestDocs
@SpringBootTest
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("/posts 요청시 title 값은 필수다.")
    void test2() throws Exception {
        PostCreate body = PostCreate.builder()
            .title("")
            .content("블로그 내용입니다.")
            .build();

        mockMvc.perform(
                        post("/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Required parameter"))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
                .andDo(
                        document("posts",
                                responseFields(
                                        fieldWithPath("status").description("Post Id"),
                                        fieldWithPath("data").description("Post 제목"),
                                        fieldWithPath("error").description("Post 내용"),
                                        fieldWithPath("message").description("Post 내용"),
                                        fieldWithPath("validation.title").description("Post 타이틀")
                                )
                        )
                );
    }

    @Test
    @DisplayName("/posts 요청시 title, content 값은 필수다.")
    void test3() throws Exception {
        PostCreate body = PostCreate.builder()
            .title("")
            .content("")
            .build();

        mockMvc.perform(
                        post("/posts")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(body))
                ).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value("400"))
                .andExpect(jsonPath("$.message").value("Required parameter"))
                .andExpect(jsonPath("$.validation.title").value("타이틀을 입력해주세요."))
                .andExpect(jsonPath("$.validation.content").value("컨텐츠을 입력해주세요."))
                .andDo(
                        document("posts-not-valid",
                                responseFields(
                                        fieldWithPath("status").description("Post Id"),
                                        fieldWithPath("data").description("Post 제목"),
                                        fieldWithPath("error").description("Post 내용"),
                                        fieldWithPath("message").description("Post 내용"),
                                        fieldWithPath("validation.title").description("Post 타이틀"),
                                        fieldWithPath("validation.content").description("Post 내용")
                                )
                        )
                );
    }

}