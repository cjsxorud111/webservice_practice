package com.jojoldu.book.springboot.service.program;


import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.program.ProgramRepository;
import com.jojoldu.book.springboot.web.dto.ProgramListResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.ProgramUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProgramService {
    private final ProgramRepository programRepository;

    @Transactional
    public Long save(ProgramSaveRequestDto requestDto) {
        return programRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, ProgramUpdateRequestDto requestDto) {
        Program programs = programRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다. id = "  + id));

        programs.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public ProgramResponseDto findById (Long id) {
        Program entity = programRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당사용자가없습니다 id=" + id));

        return new ProgramResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<ProgramListResponseDto> findAllDesc() {

        return programRepository.findAllDesc().stream()
                .map(ProgramListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id) {
        Program programs = programRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        programRepository.delete(programs);
    }
}
