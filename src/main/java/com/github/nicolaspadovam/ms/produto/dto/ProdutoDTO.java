package com.github.nicolaspadovam.ms.produto.dto;

import com.github.nicolaspadovam.ms.produto.entities.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String desc;
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        desc = produto.getDescricao();
        valor = produto.getValor();
    }
}
