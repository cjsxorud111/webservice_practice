package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.qna.Qna;
import com.jojoldu.book.springboot.domain.qna.QnaRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QnaRepositoryTest {

    @Autowired
    QnaRepository qnaRepository;

    @After
    public void cleanup() {
        qnaRepository.deleteAll();
    }

    @Test
    public void 모든qna목록_불러오기() {
        //given
        String title = "테스트 qna 제목";
        String content = "테스트 qna 본문";
        String author = "jojoldu@gmail.com";
        Long authorId = 2L;

        qnaRepository.save(Qna.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .userId(authorId)
                .build());

        //when
        List<Qna> qnasList = qnaRepository.findAll();

        //then
        Qna qna = qnasList.get(0);
        assertThat(qna.getTitle()).isEqualTo(title);
        assertThat(qna.getContent()).isEqualTo(content);
        assertThat(qna.getAuthor()).isEqualTo(author);
        assertThat(qna.getAuthorId()).isEqualTo(authorId);
    }
}
