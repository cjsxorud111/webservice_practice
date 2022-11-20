package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.config.auth.LoginUser;
import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.service.reservation.ReservationService;
import com.jojoldu.book.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReservationApiController {

    private final ReservationService reservationService;

    @PostMapping("/api/v1/reservation")
    public Long save(@RequestBody ReservationSaveRequestDto requestDto, @LoginUser SessionUser sessionUser) {
        User user = new User();
        user.setId(sessionUser.getId());
        requestDto.setUser(user);
        return reservationService.save(requestDto);
    }

    @DeleteMapping("/api/v1/reservation/{id}")
    public Long delete(@PathVariable Long id, @LoginUser SessionUser user) {
        reservationService.delete(id);
        return id;
    }

}
