package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProgramSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public ProgramSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Program toEntity() {
        return Program.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
