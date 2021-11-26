package com.dbc.biblioteca.service;

import com.dbc.biblioteca.dto.TrocaPontosDTO;
import com.dbc.biblioteca.dto.TrocaPontosCreateDTO;
import com.dbc.biblioteca.entity.TrocaPontosEntity;
import com.dbc.biblioteca.exceptions.RegraDeNegocioException;
import com.dbc.biblioteca.repository.TrocaPontosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrocaPontosService {

    private final ObjectMapper objectMapper;
    private final TrocaPontosRepository trocaPontosRepository;

    public Document create(TrocaPontosCreateDTO trocaPontosCreateDTO) {
        TrocaPontosEntity pontosEntity = objectMapper.convertValue(trocaPontosCreateDTO, TrocaPontosEntity.class);
        TrocaPontosEntity troca = trocaPontosRepository.save(pontosEntity);

        Document pontosDTO = objectMapper.convertValue(troca, Document.class);

        return pontosDTO;
    }

    public List<Document> list() {
        return trocaPontosRepository.findAll().stream()
                .map(troca -> objectMapper.convertValue(troca, Document.class))
                .collect(Collectors.toList());
    }

    public void delete(String id) throws RegraDeNegocioException{
        trocaPontosRepository.deleteById(id);
    }


}
