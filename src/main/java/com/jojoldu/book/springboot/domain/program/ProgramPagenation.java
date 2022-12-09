package com.jojoldu.book.springboot.domain.program;

import com.jojoldu.book.springboot.web.dto.PageNumber;
import com.jojoldu.book.springboot.web.dto.PageProgramListResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramListResponseDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * 프로그램 조회시 페이지리스트 분리를 위한 클래스
 */
public class ProgramPagenation {
    /**
     * 프로그램 리스트와 프로그램 페이지리스트를 리턴
     */
    public PageProgramListResponseDto pagenate(Page<Program> pagePrograms) {

        ArrayList<PageNumber> pageNumberList = new ArrayList<>();
        PageNumber PageNumber;
        Page<Program> pagenatedProgramData = pagePrograms;

        for (int i = 0; i < pagenatedProgramData.getTotalPages(); i++) {
            PageNumber = new PageNumber(i);
            pageNumberList.add(PageNumber);
        }

        return new PageProgramListResponseDto(pageNumberList, pagenatedProgramData.getContent().stream()
                .map(ProgramListResponseDto::new)
                .collect(Collectors.toList()));
    }
}
