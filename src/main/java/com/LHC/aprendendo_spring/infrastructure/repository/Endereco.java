package com.LHC.aprendendo_spring.infrastructure.repository;

import com.LHC.aprendendo_spring.infrastructure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Endereco extends JpaRepository<Telefone,Long> {
}
