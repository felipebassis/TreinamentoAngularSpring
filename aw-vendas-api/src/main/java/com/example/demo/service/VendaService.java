package com.example.demo.service;

import com.example.demo.dto.VendaDTO;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public VendaDTO adicionar(VendaDTO vendaDTO) {
        vendaDTO.setCadastro(LocalDateTime.now());
        vendaDTO.getItemDTOList().forEach(i ->{
            i.setVendaDTO(vendaDTO);
            i.setProdutoDTO(produtoRepository.findById(i.getProdutoDTO().getId()).get());
        });
        BigDecimal totalItens = vendaDTO.getItemDTOList().stream()
                .map(i -> i.getProdutoDTO().getValor().multiply(new BigDecimal(i.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        vendaDTO.setTotal(totalItens.add(vendaDTO.getFrete()));
        return vendaRepository.save(vendaDTO);
    }
}
