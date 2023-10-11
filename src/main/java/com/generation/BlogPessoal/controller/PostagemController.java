package com.generation.BlogPessoal.controller;
import com.generation.BlogPessoal.model.Postagem;
import com.generation.BlogPessoal.repostory.PostagemRepostory;
import com.generation.BlogPessoal.repostory.TemaRepostory;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders= "*")
public class PostagemController {
    @Autowired
    private PostagemRepostory postagemRepostory;
    @Autowired
    private TemaRepostory temaRepostory;
    @GetMapping
    public ResponseEntity<List <Postagem>> getAll(){
        return ResponseEntity.ok(postagemRepostory.findAll());
    }
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
        ResponseEntity.ok(postagemRepostory.findAllByTituloContainingIgnoreCase(titulo));
        return null;
    }
    @PostMapping
    public  ResponseEntity<Postagem> post(@Valid@RequestBody Postagem postagem){
        if (temaRepostory.existsById(postagem.getTema().getId()))
        return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepostory.save(postagem));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe!",null);
    }
    @PutMapping
    public ResponseEntity<Postagem> put(@Valid @RequestBody Postagem postagem) {
        if (postagemRepostory.existsById(postagem.getId())) {
            if (temaRepostory.existsById(postagem.getTema().getId()))
                return ResponseEntity.status(HttpStatus.OK).body(postagemRepostory.save(postagem));

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tema não existe", null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Postagem> postagem = postagemRepostory.findById(id);
        if (postagem.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        postagemRepostory.deleteById(id);
    }



}
