package com.solog.api.request;

import javax.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostDto {

    @Getter
    @NoArgsConstructor
    public static class PostCreateRequest {

        @NotBlank(message = "타이틀을 입력해주세요.")
        private String title;

        @NotBlank(message = "컨텐츠을 입력해주세요.")
        private String content;

        @Builder
        public PostCreateRequest(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

}
