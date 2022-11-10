package com.dev.backend.domain.entity.repository;

import com.dev.backend.domain.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long> {
}
