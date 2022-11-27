package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.qna.Qna;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QnaListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public QnaListResponseDto(Qna entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
