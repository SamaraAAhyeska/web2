package br.edu.iftm.meuAppSpringJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.iftm.meuAppSpringJava.model.Anime;
import br.edu.iftm.meuAppSpringJava.service.AnimeService;
import jakarta.validation.Valid;

@Controller
public class AnimeController {

    @Autowired
    private AnimeService AnimeService;

    @GetMapping("/anime")
    public String index(Model model) {
        model.addAttribute("animesList", AnimeService.getAllAnimes());
        return "anime/index";
    }

    @GetMapping("/anime/create")
    public String create(Model model) {
        model.addAttribute("anime", new Anime());
        return "anime/form";
    }

    @PostMapping("/anime/save")
    public String save(@ModelAttribute @Valid Anime anime, BindingResult result, Model model) {

        System.out.println(anime);
        if (result.hasErrors()) {
            model.addAttribute("anime", anime);
            return "anime/form";
        }

        animeService.saveAnime(anime);
        return "redirect:/anime";
    }

    @GetMapping("/anime/delete/{id}")
    public String delete(@PathVariable Long id) {
        this.AnimeService.deleteAnimeById(id);
        return "redirect:/anime";
    }

    @GetMapping("/anime/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Anime anime = animeService.getAnimeById(id);
        model.addAttribute("anime", anime);
        return "anime/form";
    }

}