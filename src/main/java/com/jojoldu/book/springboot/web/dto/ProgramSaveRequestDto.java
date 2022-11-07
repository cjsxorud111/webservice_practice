package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgramSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Long authorId;

    @Builder
    public ProgramSaveRequestDto(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public Program toEntity() {
        return Program.builder()
                .title(title)
                .content(content)
                .author(author)
                .userId(authorId)
                .build();
    }
}
