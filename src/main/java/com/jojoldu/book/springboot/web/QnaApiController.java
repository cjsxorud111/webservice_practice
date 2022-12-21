package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.qna.QnaService;
import com.jojoldu.book.springboot.web.dto.QnaResponseDto;
import com.jojoldu.book.springboot.web.dto.QnaSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.QnaUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class QnaApiController {

    private final QnaService qnaService;

    @PostMapping("/api/v1/qna")
    public Long save(@RequestBody QnaSaveRequestDto requestDto, @LoginUser SessionUser user) {
        requestDto.setAuthorId(user.getId());
        return qnaService.save(requestDto);
    }

    @PutMapping("/api/v1/qna/{id}")
    public Long update(@PathVariable Long id, @RequestBody QnaUpdateRequestDto requestDto) {
        return qnaService.update(id, requestDto);
    }

    @GetMapping("/api/v1/qna/{id}")
    public QnaResponseDto findById (@PathVariable Long id) {
        return qnaService.findById(id);
    }

    @DeleteMapping("/api/v1/qna/{id}")
    public Long delete (@PathVariable Long id) {
        qnaService.delete(id);
        return id;
    }
}
