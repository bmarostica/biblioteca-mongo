package com.dbc.biblioteca.service;

import com.dbc.biblioteca.dto.LivroCreateDTO;
import com.dbc.biblioteca.dto.LivroDTO;
import com.dbc.biblioteca.dto.TrocaPontosDTO;
import com.dbc.biblioteca.entity.LivroEntity;
import com.dbc.biblioteca.entity.TrocaPontosEntity;
import com.dbc.biblioteca.exceptions.RegraDeNegocioException;
import com.dbc.biblioteca.repository.TrocaPontosRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrocaPontosService {

    private final ObjectMapper objectMapper;
    private final TrocaPontosRepository trocaPontosRepository;

    public TrocaPontosDTO create(TrocaPontosDTO trocaPontosDTO) {
        TrocaPontosEntity pontosEntity = objectMapper.convertValue(trocaPontosDTO, TrocaPontosEntity.class);
        TrocaPontosEntity troca = trocaPontosRepository.save(pontosEntity);

        TrocaPontosDTO pontosDTO = objectMapper.convertValue(troca, TrocaPontosDTO.class);

        return pontosDTO;
    }

    public List<TrocaPontosDTO> list() {
        return trocaPontosRepository.findAll().stream()
                .map(troca -> objectMapper.convertValue(troca, TrocaPontosDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(String id) throws RegraDeNegocioException{
        trocaPontosRepository.deleteById(id);
    }


}
