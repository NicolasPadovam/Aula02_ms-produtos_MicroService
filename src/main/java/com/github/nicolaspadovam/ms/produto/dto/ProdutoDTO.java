package com.github.nicolaspadovam.ms.produto.dto;

import com.github.nicolaspadovam.ms.produto.entities.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProdutoDTO {

    private Long id;

    @NotBlank(message = "Campo nome é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Campo descricao é obrigatório")
    @Size(min = 10, message = "A descricao deve ter entre no minimo 10 caracteres")
    private String desc;

    @NotNull(message = "Campo valor é obrigatório")
    @Positive(message = "O valor deve ser um número psitivo maior que zero")
    private Double valor;

    public ProdutoDTO(Produto produto) {
        id = produto.getId();
        nome = produto.getNome();
        desc = produto.getDescricao();
        valor = produto.getValor();
    }
}
