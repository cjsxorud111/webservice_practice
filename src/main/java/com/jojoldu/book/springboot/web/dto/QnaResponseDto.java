package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.qna.Qna;
import lombok.Getter;

@Getter
public class QnaResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public QnaResponseDto(Qna entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
