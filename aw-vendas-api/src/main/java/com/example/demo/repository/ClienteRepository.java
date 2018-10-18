package com.example.demo.repository;

import com.example.demo.dto.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDTO, Long> {

}
