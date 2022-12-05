package com.jojoldu.book.springboot.domain.program;

import com.jojoldu.book.springboot.web.dto.PageListResponseDto;
import com.jojoldu.book.springboot.web.dto.PageProgramListResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramListResponseDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProgramPagenation {

    public PageProgramListResponseDto pagenate(Page<Program> pagePrograms) {

        ArrayList<PageListResponseDto> pageNumberList = new ArrayList<>();
        PageListResponseDto pageListResponseDto;
        Page<Program> pagenatedProgramData = pagePrograms;

        for (int i = 0; i < pagenatedProgramData.getTotalPages(); i++) {
            pageListResponseDto = new PageListResponseDto(i);
            pageNumberList.add(pageListResponseDto);
        }

        return new PageProgramListResponseDto(pageNumberList, pagenatedProgramData.getContent().stream()
                .map(ProgramListResponseDto::new)
                .collect(Collectors.toList()));
    }

}
