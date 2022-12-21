package com.jojoldu.book.springboot.service.qna;


import com.jojoldu.book.springboot.domain.qna.Qna;
import com.jojoldu.book.springboot.domain.qna.QnaRepository;
import com.jojoldu.book.springboot.web.dto.QnaResponseDto;
import com.jojoldu.book.springboot.web.dto.QnaSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.QnaUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class QnaService {
    private final QnaRepository qnaRepository;

    @Transactional
    public Long save(QnaSaveRequestDto requestDto) {
        return qnaRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<Qna> findAllDesc(Pageable pageable) {
        return qnaRepository.findAllDesc(pageable);
    }

    @Transactional(readOnly = true)
    public QnaResponseDto findById(Long id) {
        Qna entity =  qnaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당사용자가없습니다 id=" + id));

        return new QnaResponseDto(entity);
    }

    @Transactional
    public void delete (Long id) {
        Qna qna = qnaRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        qnaRepository.delete(qna);
    }

    @Transactional
    public Long update(Long id, QnaUpdateRequestDto requestDto) {
        Qna qna = qnaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다. id = "  + id));

        qna.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
}
