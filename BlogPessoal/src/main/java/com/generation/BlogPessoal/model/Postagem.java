package com.generation.BlogPessoal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="tb_postagens")
public class Postagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O atributo título é obrigatório")
    @Size(min = 5,max = 100,message = "O atributo título deve ter no mínimo de 5 caracteres r no máximo 100.")
    private String titulo;
    @NotBlank(message = "O atributo título é obrigatório")
    @Size(min = 10,max = 1000,message = "O atributo título deve ter no mínimo de 10 caracteres r no máximo 1000.")

    private String texto;
    @UpdateTimestamp
    private LocalDateTime data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
