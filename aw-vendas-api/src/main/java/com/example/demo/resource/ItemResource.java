package com.example.demo.resource;

import com.example.demo.dto.ItemDTO;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemResource {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<ItemDTO> listar() {
        return itemRepository.findAll();
    }
}
