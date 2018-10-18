package com.example.demo.repository;

import com.example.demo.dto.ProdutoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoDTO, Long> {
}
