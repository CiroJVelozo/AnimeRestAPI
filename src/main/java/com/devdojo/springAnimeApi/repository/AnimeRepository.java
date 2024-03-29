package com.devdojo.springAnimeApi.repository;

import com.devdojo.springAnimeApi.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime,Long> {

    List<Anime> findByName(String name);
}
