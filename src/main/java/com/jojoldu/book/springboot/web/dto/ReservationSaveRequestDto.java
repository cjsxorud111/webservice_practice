package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReservationSaveRequestDto {

    private Long programId;
    private String date;
    private Long phoneNumber;
    private String uniqueness;

    @Builder
    public ReservationSaveRequestDto(Long programId, String date, Long phoneNumber, String uniqueness) {
        this.programId = programId;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.uniqueness = uniqueness;
    }

/*    public Program toEntity() {
        return Program.builder()
                .title(title)
                .content(content)
                .author(author)
                .userId(authorId)
                .build();
    }*/
}
