package com.dbc.biblioteca.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
@Document
public class TrocaPontosEntity {
    @Id
    String idTroca;
    String titulo;
    String autor;
    String genero;
}
