package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.program.ProgramRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramRepositoryTest {

    @Autowired
    ProgramRepository programRepository;

    @After
    public void cleanup() {
        programRepository.deleteAll();
    }

    @Test
    public void 모든프로그램목록_조회() {
        //given
        String title = "테스트 프로그램 제목";
        String content = "테스트 프로그램 컨텐츠 본문 제목";
        String author = "jojoldu@gmail.com";
        Long authorId = 2L;

        programRepository.save(Program.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .userId(authorId)
                .build());

        //when
        List<Program> programsList = programRepository.findAll();

        //then
        Program programs = programsList.get(0);
        assertThat(programs.getTitle()).isEqualTo(title);
        assertThat(programs.getContent()).isEqualTo(content);
        assertThat(programs.getAuthor()).isEqualTo(author);
        assertThat(programs.getAuthorId()).isEqualTo(authorId);
    }

    @Test
    public void ID와일치하는프로그램_조회() {
        //given
        String title = "테스트 프로그램 제목";
        String content = "테스트 프로그램 컨텐츠 본문 제목";
        String author = "jojoldu@gmail.com";
        Long authorId = 2L;
        Long id = 1L;

        programRepository.save(Program.builder()
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .userId(authorId)
                .build());

        //when
        Optional<Program> optionalProgram = programRepository.findById(id);
        Program program = null;
        if (optionalProgram.isPresent()) program = optionalProgram.get();

        //then
        assertThat(program.getTitle()).isEqualTo(title);
        assertThat(program.getId()).isEqualTo(id);
        assertThat(program.getContent()).isEqualTo(content);
        assertThat(program.getAuthor()).isEqualTo(author);
        assertThat(program.getAuthorId()).isEqualTo(authorId);

    }
}
