package io.github.alexagalvao.domain.repository;

import io.github.alexagalvao.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
