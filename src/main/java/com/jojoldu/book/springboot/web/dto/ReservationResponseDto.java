package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.reservation.Reservation;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationResponseDto {
    private Long id;
    private Program program;
    private Date date;
    private String phoneNumber;
    private String uniqueness;
    private User author;
    private LocalDateTime reservationCreateDate;

    public ReservationResponseDto(Reservation entity) {
        this.id = entity.getId();
        this.program = entity.getProgram();
        this.date = entity.getDate();
        this.phoneNumber = entity.getPhoneNumber();
        this.uniqueness = entity.getUniqueness();
        this.author = entity.getUser();
        this.reservationCreateDate = entity.getCreatedDate();
    }
}
