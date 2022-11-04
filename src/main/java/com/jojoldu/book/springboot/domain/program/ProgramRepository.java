package com.jojoldu.book.springboot.domain.program;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    @Query(value = "SELECT p FROM Program p ORDER BY p.id DESC")
    List<Program> findAllDesc();
}
