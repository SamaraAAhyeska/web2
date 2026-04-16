package br.edu.iftm.meuAppSpringJava.service;

import java.util.List;

import br.edu.iftm.meuAppSpringJava.model.Anime;

public interface AnimeService {

    List <Anime> getAllAnime();
    void saveAnime(Product anime);
    Anime getAnimeById(long id);
    void deleteAnimeById(long id);
}