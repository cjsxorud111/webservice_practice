package com.jojoldu.book.springboot.service.program;

import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.program.ProgramRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ProgramServiceTest {
    private ProgramService mockProgramService = mock(ProgramService.class);
    private ProgramRepository mockProgramRepository = mock(ProgramRepository.class);

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void ID로_프로그램조회_테스트() {
        //given
        Long id = 1L;
        Program program = Program.builder()
                .title("프로그램제목0")
                .content("프로그램컨텐츠0")
                .author("프로그램작성자0")
                .userId(1L)
                .build();
        program.setId(id);

        when(mockProgramRepository.findById(id)).thenReturn(Optional.ofNullable(program));

        //when
        Program entity = mockProgramRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당사용자가없습니다 id=" + id));

        //then
        assertThat(entity).isEqualTo(program);
    }

    @Test
    void 일치하는ID프로그램이없을때() {
        //given
        Long id = 1L;
        when(mockProgramRepository.findById(id)).thenReturn(Optional.ofNullable(null));

        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            mockProgramRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당사용자가없습니다 id=" + id));
        });
    }

    @Test
    void findAllDesc테스트() {
        //given
        Pageable pageable = mock(Pageable.class);
        Program program = Program.builder()
                .title("프로그램제목0")
                .content("프로그램컨텐츠0")
                .author("프로그램작성자0")
                .userId(1L)
                .build();
        program.setId(13L);

        List<Program> programList = new ArrayList<>();
        programList.add(program);
        Page<Program> pagenatedProgramList = new PageImpl<>(programList);
        when(mockProgramService.findAllDesc(pageable)).thenReturn(pagenatedProgramList);

        //when
        Page<Program> pagenatedProgramListForTest = mockProgramService.findAllDesc(pageable);

        //then
        assertThat(pagenatedProgramListForTest.getContent()).isEqualTo(programList);
    }

    @Test
    void delete() {
    }
}