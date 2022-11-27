package com.jojoldu.book.springboot.domain.qna;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface QnaRepository extends JpaRepository<Qna, Long> {
    @Query(value = "SELECT p FROM Qna p ORDER BY p.id DESC")
    Page<Qna> findAllDesc(Pageable pageable);
}
