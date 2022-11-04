package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import lombok.Getter;

@Getter
public class ProgramResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public ProgramResponseDto(Program entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
