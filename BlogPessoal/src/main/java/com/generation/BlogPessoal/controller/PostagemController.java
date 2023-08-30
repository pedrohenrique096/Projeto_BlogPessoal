package com.generation.BlogPessoal.controller;
import com.generation.BlogPessoal.model.Postagem;
import com.generation.BlogPessoal.repostory.PostagemRepostory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class PostagemController {
    @Autowired
    private PostagemRepostory postagemRepostory;
    @GetMapping
    public ResponseEntity<List <Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepostory.findAll());
    }


}
