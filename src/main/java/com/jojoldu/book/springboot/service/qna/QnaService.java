package com.jojoldu.book.springboot.service.qna;


import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.program.ProgramRepository;
import com.jojoldu.book.springboot.domain.qna.Qna;
import com.jojoldu.book.springboot.domain.qna.QnaRepository;
import com.jojoldu.book.springboot.web.dto.QnaSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class QnaService {
    private final ProgramRepository programRepository;
    private final QnaRepository qnaRepository;

    @Transactional
    public Long save(QnaSaveRequestDto requestDto) {
        return qnaRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<Qna> findAllDesc(Pageable pageable) {
        return qnaRepository.findAllDesc(pageable);
    }

    @Transactional
    public void delete (Long id) {
        Program programs = programRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        programRepository.delete(programs);
    }
}
