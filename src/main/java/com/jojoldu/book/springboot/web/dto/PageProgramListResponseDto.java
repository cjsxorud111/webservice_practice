package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class PageProgramListResponseDto {
    private final ArrayList<PageNumber> pageNumberList;
    private final List<ProgramListResponseDto> programListResponseDtoList;
}
