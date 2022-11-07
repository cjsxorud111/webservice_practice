package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.service.program.ProgramService;
import com.jojoldu.book.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReservationApiController {

    private final ProgramService programService;

    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto requestDto, @LoginUser SessionUser user) {
        return null;
    }

}
