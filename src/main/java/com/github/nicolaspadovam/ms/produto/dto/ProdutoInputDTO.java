package com.github.nicolaspadovam.ms.produto.dto;

public class ProdutoInputDTO {
    private String nome;
    private String desc;
    private Double valor;


    public ProdutoInputDTO(String nome, String desc, Double valor) {
        this.nome = nome;
        this.desc = desc;
        this.valor = valor;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
