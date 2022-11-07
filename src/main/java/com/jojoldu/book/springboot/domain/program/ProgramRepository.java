package com.jojoldu.book.springboot.domain.program;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface ProgramRepository extends JpaRepository<Program, Long> {
    @Query(value = "SELECT p FROM Program p ORDER BY p.id DESC")
    Page<Program> findAllDesc(Pageable pageable);
}
