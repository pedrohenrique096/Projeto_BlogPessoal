package com.generation.BlogPessoal.repostory;

import com.generation.BlogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
    public Optional <Usuario> findByUsuario(String usuario);
}
