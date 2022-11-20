package com.jojoldu.book.springboot.domain.reservation;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import com.jojoldu.book.springboot.domain.program.Program;
import com.jojoldu.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Getter
@NoArgsConstructor
@Entity
@Table(name="APOINTMENT")
public class Reservation extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "PROGRAM_ID")
    private Program program;

    @Column(name = "apointment_date")
    private Date date;

    @Column(name = "phone_number", length = 500)
    private String phoneNumber;

    @Column(columnDefinition = "clob", nullable = false)
    private String uniqueness;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Builder
    public Reservation(Program programId, Date date, String phoneNumber, String uniqueness, User user) {
        this.program = programId;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.uniqueness = uniqueness;
        this.user = user;
    }
}
