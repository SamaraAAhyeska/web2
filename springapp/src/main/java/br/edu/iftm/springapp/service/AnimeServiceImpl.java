package br.edu.iftm.meuAppSpringJava.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.meuAppSpringJava.model.Anime;
import br.edu.iftm.meuAppSpringJava.repository.AnimeRepository;
import br.edu.iftm.meuAppSpringJava.service.AnimeService;


@Service
public class AnimeServiceImpl implements AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Override
    public List <Anime> getAllAnimes(){
        return animeRepository.findAll();
    }

    @Override
    public void saveAnime(Anime anime){
        this.animeRepository.save(anime);
    }

    @Override
    public Anime getAnimeById(long id) {
        Optional < Anime > optional = animeRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Anime not found with id: " + id);
        }
    }

    @Override
    public void deleteAnimeById(long id) {
        this.animeRepository.deleteById(id);
    }

}