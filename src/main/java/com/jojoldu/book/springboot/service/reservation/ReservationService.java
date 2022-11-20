package com.jojoldu.book.springboot.service.reservation;

import com.jojoldu.book.springboot.domain.reservation.Reservation;
import com.jojoldu.book.springboot.domain.reservation.ReservationRepository;
import com.jojoldu.book.springboot.domain.user.User;
import com.jojoldu.book.springboot.web.dto.ReservationResponseDto;
import com.jojoldu.book.springboot.web.dto.ReservationSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    @Transactional
    public List<ReservationResponseDto> findAllByAuthorId(Long id) {

        List<Reservation> reservations = reservationRepository.findAllByUser(User.builder().id(id).build());

        return reservations.stream()
                .map(ReservationResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Page<Reservation> findAllDesc(Pageable pageable) {
        return reservationRepository.findAllDesc(pageable);
    }

    @Transactional
    public Long save(ReservationSaveRequestDto requestDto) {

        Long id = reservationRepository.save(requestDto.toEntity()).getId();
        return id;
    }

    @Transactional
    public void delete(Long id) {

        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 예약내역이 없습니다. id="
                        + id));

        reservationRepository.delete(reservation);
    }
}
