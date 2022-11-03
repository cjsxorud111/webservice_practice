package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.service.program.ProgramService;
import com.jojoldu.book.springboot.web.dto.ProgramResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramSaveRequestDto;
import com.jojoldu.book.springboot.web.dto.ProgramUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProgramApiController {

    private final ProgramService programService;

    @PostMapping("/api/v1/program")
    public Long save(@RequestBody ProgramSaveRequestDto requestDto) {
        Long a = programService.save(requestDto);
        return a;
    }

    @PutMapping("/api/v1/program/{id}")
    public Long update(@PathVariable Long id, @RequestBody ProgramUpdateRequestDto requestDto) {
        return programService.update(id, requestDto);
    }

    @GetMapping("/api/v1/program/{id}")
    public ProgramResponseDto findById (@PathVariable Long id) {
        return programService.findById(id);

    }

    @DeleteMapping("/api/v1/program/{id}")
    public Long delete (@PathVariable Long id) {
        programService.delete(id);
        return id;
    }
}