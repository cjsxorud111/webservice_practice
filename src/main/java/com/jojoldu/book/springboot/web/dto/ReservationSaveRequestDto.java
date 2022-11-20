package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.reservation.Reservation;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class ReservationSaveRequestDto {

    private Long programId;
    private Date date;
    private String phoneNumber;
    private String uniqueness;

    private User user;

    @Builder
    public ReservationSaveRequestDto(Long programId, Date date, String phoneNumber, String uniqueness, User user) {
        this.programId = programId;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.uniqueness = uniqueness;
        this.user = user;
    }

    public Reservation toEntity() {
        Program program = new Program();
        program.setId(programId);

        return Reservation.builder()
                .programId(program)
                .date(date)
                .phoneNumber(phoneNumber)
                .uniqueness(uniqueness)
                .user(user)
                .build();
    }
}
