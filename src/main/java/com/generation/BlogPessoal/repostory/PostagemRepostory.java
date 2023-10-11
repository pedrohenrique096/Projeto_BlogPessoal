package com.generation.BlogPessoal.repostory;

import com.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostagemRepostory extends JpaRepository<Postagem,Long> {
public List<Postagem> findAllByTituloContainingIgnoreCase (@Param("titulo")String titulo);
}
