package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProgramListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public ProgramListResponseDto(Program entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
