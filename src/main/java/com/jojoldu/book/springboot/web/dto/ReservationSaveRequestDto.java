package com.jojoldu.book.springboot.web.dto;

import com.jojoldu.book.springboot.domain.reservation.Reservation;
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
    private Long authorId;

    @Builder
    public ReservationSaveRequestDto(Long programId, Date date, String phoneNumber, String uniqueness, Long authorId) {
        this.programId = programId;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.uniqueness = uniqueness;
        this.authorId = authorId;
    }

    public Reservation toEntity() {
        return Reservation.builder()
                .programId(programId)
                .date(date)
                .phoneNumber(phoneNumber)
                .uniqueness(uniqueness)
                .authorId(authorId)
                .build();
    }
}
