package com.teste.cinema.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.cinema.model.Filme;
import com.teste.cinema.repository.FilmeRepository;

@Service
public class FilmeService {
    @Autowired
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository){
        this.filmeRepository = filmeRepository;
    }

    public Filme salvarFilme(Filme filme){
        return filmeRepository.save(filme);
    }

    public List<Filme> listarFilmes(){
        return filmeRepository.findAll();
    }

    public Filme buscarFilmePorId(Long id){
        Optional<Filme> filme = filmeRepository.findById(id);
        if (filme.isPresent()) {
            return filme.get();
        } else {
            throw new RuntimeException("Filme não encontrado com ID:" + id);
        }
    }

    public Filme atualizarFilme(Long id, Filme filmeAtualizado){
        Filme filmeExistente = buscarFilmePorId(id);
        filmeExistente.setTitulo(filmeAtualizado.getTitulo());
        filmeExistente.setGenero(filmeAtualizado.getGenero());
        filmeExistente.setDuracao(filmeAtualizado.getDuracao());
        filmeExistente.setClassificacao(filmeAtualizado.getClassificacao());
        return filmeRepository.save(filmeExistente);
    }

    public void deletarFilme(Long id){
        filmeRepository.deleteById(id);
    }
}
