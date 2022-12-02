package com.jojoldu.book.springboot.service.qna;

import com.jojoldu.book.springboot.domain.qna.Qna;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QnaServiceTest {

    @Test
    public void save() {
    }

    @Test
    public void findAllDesc() {
        //given
        Pageable pageable = mock(Pageable.class);
        QnaService mockQnaService = mock(QnaService.class);
        Qna qna = Qna.builder()
                .title("qna테스트제목0")
                .content("qna테스트컨텐츠0")
                .author("qna테스트작성자0")
                .userId(1L)
                .build();

        qna.setId(13L);
        List<Qna> qnaList = new ArrayList<>();
        qnaList.add(qna);
        Page<Qna> pagenatedQnaList = new PageImpl<>(qnaList);
        when(mockQnaService.findAllDesc(pageable)).thenReturn(pagenatedQnaList);

        //when
        Page<Qna> pagenatedQnaListForTest = mockQnaService.findAllDesc(pageable);

        //then
        assertThat(pagenatedQnaListForTest.getContent()).isEqualTo(qnaList);
    }

    @Test
    public void delete() {
    }
}