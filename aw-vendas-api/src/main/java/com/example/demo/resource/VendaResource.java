package com.example.demo.resource;

import com.example.demo.dto.VendaDTO;
import com.example.demo.repository.VendaRepository;
import com.example.demo.service.VendaService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/vendas")
public class VendaResource  {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<VendaDTO> list() {
        return  vendaRepository.findAll();
    }

    @PostMapping
    public VendaDTO adicionar(@RequestBody @Valid VendaDTO vendaDTO) {
        return vendaService.adicionar(vendaDTO);
    }
}
