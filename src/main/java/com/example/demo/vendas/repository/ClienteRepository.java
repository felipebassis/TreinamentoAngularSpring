package com.example.demo.vendas.repository;

import com.example.demo.vendas.model.ClienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteDTO, Long> {

}
