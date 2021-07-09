package com.devdojo.springAnimeApi.controller;


import com.devdojo.springAnimeApi.form.AnimeForm;
import com.devdojo.springAnimeApi.form.AnimePutForm;
import com.devdojo.springAnimeApi.model.Anime;
import com.devdojo.springAnimeApi.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> allAnimes(){
        return ResponseEntity.ok(animeService.allAnimes());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findAnimeById(@PathVariable Long id){
        return ResponseEntity.ok(animeService.findAnimeById(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Anime>> findAnimeById(@RequestParam(required = false) String name){
        return ResponseEntity.ok(animeService.findByName(name));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Anime> saveAnime(@RequestBody @Valid AnimeForm animeForm){
        return new ResponseEntity<>( animeService.saveAnime(animeForm),HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE,path = "/{id}")
    //@DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        animeService.removeAnime(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateAnime(@RequestBody @Valid AnimePutForm animePutForm){
        animeService.updateAnime(animePutForm);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
