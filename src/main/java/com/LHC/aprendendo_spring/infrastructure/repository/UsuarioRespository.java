package com.LHC.aprendendo_spring.infrastructure.repository;

import com.LHC.aprendendo_spring.infrastructure.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRespository extends JpaRepository<Usuario, Long> {

    public boolean existsByEmail(String email);

    public Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);
}
