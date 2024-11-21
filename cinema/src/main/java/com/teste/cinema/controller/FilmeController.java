package com.teste.cinema.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.cinema.model.Filme;
import com.teste.cinema.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    
    private FilmeService filmeService;

    public FilmeController(FilmeService filmeService){
        this.filmeService = filmeService;
    }
    
    @GetMapping
    public List<Filme> listarFilmes(){
        return filmeService.listarFilmes();
    }

   @GetMapping("/{id}")
   public Filme buscarFilmePorId(@PathVariable Long id){
        return filmeService.buscarFilmePorId(id);
   }

    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme){
        return filmeService.salvarFilme(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado){
        return filmeService.atualizarFilme(id, filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Long id){
        filmeService.deletarFilme(id);
    }
}
