package com.example.demo.repository;

import com.example.demo.dto.VendaDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<VendaDTO, Long> {
}
