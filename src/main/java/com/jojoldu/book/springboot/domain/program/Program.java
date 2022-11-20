package com.jojoldu.book.springboot.domain.program;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Program extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "clob", nullable = false)
    private String content;

    private String author;

    @Column(name = "author_id", nullable = false)
    private Long authorId;

    @Builder
    public Program(String title, String content, String author, Long userId) { //생성자
        this.title = title;
        this.content = content;
        this.author = author;
        this.authorId = userId;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
