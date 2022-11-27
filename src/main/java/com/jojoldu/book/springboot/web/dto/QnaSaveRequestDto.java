package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.qna.Qna;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QnaSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Long authorId;

    @Builder
    public QnaSaveRequestDto(String title, String content, String author, Long authorId) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = authorId;
    }

    public Qna toEntity() {
        return Qna.builder()
                .title(title)
                .content(content)
                .author(author)
                .userId(authorId)
                .build();
    }
}
