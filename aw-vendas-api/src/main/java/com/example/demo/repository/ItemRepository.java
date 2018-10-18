package com.example.demo.repository;

import com.example.demo.dto.ItemDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemDTO, Long> {
}
