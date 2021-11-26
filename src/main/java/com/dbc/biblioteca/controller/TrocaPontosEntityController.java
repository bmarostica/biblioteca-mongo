package com.dbc.biblioteca.controller;
import com.dbc.biblioteca.dto.TrocaPontosDTO;
import com.dbc.biblioteca.exceptions.RegraDeNegocioException;
import com.dbc.biblioteca.service.TrocaPontosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/trocaPontos")
@Validated
@RequiredArgsConstructor
@Slf4j
public class TrocaPontosEntityController {
    private final TrocaPontosService trocaPontosService;

    @ApiOperation(value = "Lista todos os livros disponíveis para troca")
    @GetMapping
    public List<TrocaPontosDTO> list() {
        return trocaPontosService.list();
    }

    @ApiOperation("Cria um novo livro.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Livro criado com sucesso!"),
            @ApiResponse(code = 400, message = "Erro, informação inconsistente."),
            @ApiResponse(code = 500, message = "Erro interno, exceção gerada.")
    })
    @PostMapping
    public TrocaPontosDTO create(@RequestBody @Valid TrocaPontosDTO trocaPontosDTO){
        log.info("Criando livro...");
        TrocaPontosDTO livro = trocaPontosService.create(trocaPontosDTO);
        log.info("Livro criado com sucesso!");

        return livro;
    }

    @ApiOperation("Deleta um livro existente através do id.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Livro deletado com sucesso!"),
            @ApiResponse(code = 400, message = "Erro, informação inconsistente."),
            @ApiResponse(code = 500, message = "Erro interno, exceção gerada.")
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) throws RegraDeNegocioException {
        log.info("Deletando livro...");
        TrocaPontosService.delete(id);
        log.info("Livro deletado com sucesso!");
    }
}
