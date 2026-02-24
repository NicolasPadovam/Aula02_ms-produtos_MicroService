package com.github.nicolaspadovam.ms.produto.controller;

import com.github.nicolaspadovam.ms.produto.dto.ProdutoDTO;
import com.github.nicolaspadovam.ms.produto.dto.ProdutoInputDTO;
import com.github.nicolaspadovam.ms.produto.dto.ProdutoResponseDTO;
import com.github.nicolaspadovam.ms.produto.entities.Produto;
import com.github.nicolaspadovam.ms.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //PRIMEIRO COMMIT
//    @GetMapping
//    public ResponseEntity<List<ProdutoResponseDTO>> getProdutos() {
//        List<ProdutoResponseDTO> dto = ProdutoResponseDTO.createMock();
//        return ResponseEntity.ok(dto);
//    }
//
//
//    @PostMapping
//    public ResponseEntity<ProdutoResponseDTO> createProdutos(@RequestBody ProdutoInputDTO inputDTO) {
//        ProdutoResponseDTO dto = new ProdutoResponseDTO(1L, inputDTO.getNome(), inputDTO.getDesc(), inputDTO.getValor());
//
//        return ResponseEntity.created(null).body(dto);
//    }
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {

        List<ProdutoDTO> list = produtoService.findAllProdutos();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id) {
        ProdutoDTO produtoDTO = produtoService.findProdutoById(id);
        return ResponseEntity.ok(produtoDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) {

        produtoDTO = produtoService.saveProduto(produtoDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(produtoDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(produtoDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id,
                                                    @RequestBody ProdutoDTO produtoDTO) {
        produtoDTO = produtoService.updateProduto(id, produtoDTO);

        return ResponseEntity.ok(produtoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        produtoService.deleteProdutoById(id);
        return ResponseEntity.noContent().build();

    }


}
