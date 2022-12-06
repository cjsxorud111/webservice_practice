package com.jojoldu.book.springboot.domain.program;

import com.jojoldu.book.springboot.web.dto.PageNumber;
import com.jojoldu.book.springboot.web.dto.PageProgramListResponseDto;
import com.jojoldu.book.springboot.web.dto.ProgramListResponseDto;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ProgramPagenation {

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
