package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.*;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository.*;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.service.MaintenanceService;

import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    FilmActorRepository filmActorRepository;

    @Autowired
    FilmCategoryRepository filmCategoryRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    /**
     * GET
     */
    @Override
    public List<FilmDto> getAllFilms() {
        List<FilmDto> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            FilmDto filmDto  = new FilmDto(film.getFilmId(),film.getTitle(),film.getLanguageId().getName(),film.getRentalRate());
            films.add(filmDto);
        });
        return films;
    }

    @Override
    public FilmDetailDto getFilmById(int id) {
        Optional<Film> optional = filmRepository.findById(id);

        return optional.map(film -> new FilmDetailDto(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getLanguageId().getLanguageId(),
                        film.getLanguageId().getName(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        convertirDeStringASet(film.getSpecialFeatures()),
                        film.getLastUpdate()
                )
        ).orElse(null);
    }

    @Override
    public List<Language> getAllLanguages() {
        List<Language> lang = (List<Language>) languageRepository.findAll();
        return lang;
    }

    @Override
    public List<FilmActor> getActorFilmById(int filmId) {
        return filmActorRepository.findByFilmFilmId(filmId);
    }

    @Override
    public List<FilmCategory> getCategoryFilmById(int filmId) {
        return filmCategoryRepository.findCategoryByFilmFilmId(filmId);
    }

    @Override
    public List<FilmCategory> getAllCategories() {
        List<FilmCategory> filmCategories = (List<FilmCategory>) filmCategoryRepository.findAll();
        return filmCategories;
    }

    /**
     * CREATE
     */
    @Override
    public void createFilm(Film film) {
        Optional<Language> languageOptional = languageRepository.findById(film.getLanguageId().getLanguageId());
        Language languageOp = languageOptional.get();

        film.setLanguageId(languageOp);
        film.setOriginalLanguageId(null);
        film.setLastUpdate(new Timestamp(new Date().getTime()));
        if (film.getSpecialFeatures() != null && !film.getSpecialFeatures().isEmpty()) {
            String specialFeatures = String.join(",", convertirDeStringASet(film.getSpecialFeatures()));
            film.setSpecialFeatures(specialFeatures);
        }
        filmRepository.save(film);
    }

    /**
     * UPDATE
     */
    @Override
    public void updateFilm(FilmDetailDto filmDetailDto) {
        Optional<Film> filmOptional = filmRepository.findById(filmDetailDto.filmId());

        Film film = filmOptional.get();

        film.setTitle(filmDetailDto.title());
        film.setDescription(filmDetailDto.description());
        film.setReleaseYear(filmDetailDto.releaseYear());
        film.setRentalDuration(filmDetailDto.rentalDuration());
        film.setRentalRate(filmDetailDto.rentalRate());
        film.setLength(filmDetailDto.length());
        film.setReplacementCost(filmDetailDto.replacementCost());
        film.setRating(filmDetailDto.rating());
        if (filmDetailDto.specialFeatures() != null) {
            String specialFeatures = String.join(",", filmDetailDto.specialFeatures());
            film.setSpecialFeatures(specialFeatures);
        }
        film.setLastUpdate(new Timestamp(new Date().getTime()));

        filmRepository.save(film);
    }

    /**
     * DELETE
     */
    @Override
    public void deleteFilm(Integer id) {
        System.out.println("ID PARA REMOVER " + id);
        filmRepository.deleteById(id);
    }

    @Override
    public List<Inventory> getAllInventories(int filmId) {
        return inventoryRepository.findByFilmId_FilmId(filmId);
    }

    //METODO AUXILIAR PARA CONVERTIR STRING A SET, YA QUE SE LE ESTARA PASANDO UN ARRAY DE STRING Y LA BD ES UN SET
    private Set<String> convertirDeStringASet(String specialFeatures) {
        //EN CASO NO HAYA ITEMS O STRING DEVUELVE UN CONJUNTO VACIO
        if (specialFeatures == null || specialFeatures.isEmpty()) {
            return new HashSet<>();
        }
        //SE ELIMINA LOS ESPACIOS Y/O "," PARA COLOCARLOS EN UN COLLLECTOR-SET
        return Arrays.stream(specialFeatures.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

}
