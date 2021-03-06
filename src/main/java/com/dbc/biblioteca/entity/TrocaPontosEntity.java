package com.dbc.biblioteca.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "troca")
public class TrocaPontosEntity {
    @Id
    private String id;
    private String titulo;
    private String autor;
    private String genero;
}
