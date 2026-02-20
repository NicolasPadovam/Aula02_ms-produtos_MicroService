package com.github.nicolaspadovam.ms.produto.repositories;

import com.github.nicolaspadovam.ms.produto.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
