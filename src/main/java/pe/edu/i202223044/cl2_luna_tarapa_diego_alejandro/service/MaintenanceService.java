package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.service;

import org.springframework.cache.annotation.CacheEvict;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailCategoryDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.*;

import java.util.List;

public interface MaintenanceService {
    /**
     * FILMS
     */
    //GET FILM ALL - HALLAR TODOS LOS FILMS
    List<FilmDto> getAllFilms();

    //GET FILM ID - HALLAR FILM POR ID;
    FilmDetailDto getFilmById(int id);

    //CREATE FILM
    void createFilm(FilmDetailCategoryDto film, Integer categoryCode);

    //UPDATE FILM
    void updateFilm(FilmDetailDto filmDetailDto);

    //DELETE FILM
    void deleteFilm(Integer id);

    /**
     * LANGUAGE
     */
    //GET LANG ALL - HALLAR TODOS LOS LANGUAGES
    List<Language> getAllLanguages();



}
