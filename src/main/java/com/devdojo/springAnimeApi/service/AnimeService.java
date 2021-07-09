package com.devdojo.springAnimeApi.service;

import com.devdojo.springAnimeApi.exception.BadrequestException;
import com.devdojo.springAnimeApi.form.AnimeForm;
import com.devdojo.springAnimeApi.form.AnimePutForm;
import com.devdojo.springAnimeApi.model.Anime;
import com.devdojo.springAnimeApi.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Log4j2
@RequiredArgsConstructor
public class AnimeService {

    private final AnimeRepository animeRepository;

    public List<Anime> allAnimes(){
        return animeRepository.findAll();
    }

    public Anime findAnimeById(Long id) throws ResponseStatusException {
        return animeRepository.findById(id)
                .orElseThrow(()-> new BadrequestException("bad request"));
    }

    public List<Anime> findByName(String name){
        return animeRepository.findByName(name);
    }

    public Anime saveAnime(AnimeForm animeForm){
        Anime anime = Anime.builder().name(animeForm.getName()).build();
        return animeRepository.save(anime);//
    }

    public void removeAnime(Long id){
        animeRepository.delete(this.findAnimeById(id));
    }

    public void updateAnime(AnimePutForm animePutForm){
        Anime anime = this.findAnimeById(animePutForm.getId());
        anime.setName(animePutForm.getName());
        animeRepository.save(anime);
    }
}
