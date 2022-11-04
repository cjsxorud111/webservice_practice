package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgramUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public ProgramUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
