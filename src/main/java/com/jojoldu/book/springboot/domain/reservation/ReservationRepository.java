package com.jojoldu.book.springboot.domain.reservation;

import com.jojoldu.book.springboot.domain.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    //@Query(value = "SELECT p FROM Reservation p join fetch p.programId where p.authorId = :id")
    //@Query(value = "SELECT p FROM Reservation p join fetch p.program where p.authorId = ?1")
    //@Query(value = "SELECT p FROM Reservation p WHERE p.authorId = ?1")
    List<Reservation> findAllByUser(User user);
    @Query(value = "SELECT p FROM Reservation p ORDER BY p.id DESC")
    Page<Reservation> findAllDesc(Pageable pageable);
}
