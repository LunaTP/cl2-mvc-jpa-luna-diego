package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.service;

import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Film;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmActor;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategory;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Language;

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
    void createFilm(Film film);

    //UPDATE FILM
    void updateFilm(FilmDetailDto filmDetailDto);

    /**
     * LANGUAGE
     */
    //GET LANG ALL - HALLAR TODOS LOS LANGUAGES
    List<Language> getAllLanguages();


    /**
     * ACTOR
     */
    //GET ACTOR ID - HALLAR LOS AUTORES SEGUN EL ID DEL FILM
    List<FilmActor> getActorFilmById(int filmId);


    /**
     * CATEGORY
     */
    //GET CATE ID - HALLAR LAS CATEGORIAS SEGUN EL ID DEL FILM
    List<FilmCategory> getCategoryFilmById(int filmId);

    //GET CATE ALL - HALLAS TODAS LAS CATEGORIAS
    List<FilmCategory> getAllCategories();
}
