package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Film;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmActor;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategory;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Language;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.service.MaintenanceService;

import java.util.List;

@Controller
@RequestMapping("/maintenance")
public class MaintenanceController {

    @Autowired
    MaintenanceService maintenanceService;

    /**
     * READ
     */
    //READ - LEER TODOS LOS FILMS
    @GetMapping("/start")
    public String start(Model model) {
        List<FilmDto> films = maintenanceService.getAllFilms();
        model.addAttribute("films", films);
        return "maintenance";
    }

    //READ - LEER FILM POR ID
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);
        List<FilmActor> filmActors = maintenanceService.getActorFilmById(id);
        List<FilmCategory> filmCategories = maintenanceService.getCategoryFilmById(id);
        model.addAttribute("filmCategories",filmCategories);
        model.addAttribute("filmActors",filmActors);
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";
    }

    /**
     * CREATE
     */
    @GetMapping("/createFilm")
    public String save(Model model) {
        Film film = new Film();
        List<Language> listLanguage = maintenanceService.getAllLanguages();
        List<FilmCategory> filmCategories = maintenanceService.getAllCategories();
        model.addAttribute("film",film);
        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("filmCategories", filmCategories);
        return "maintenance-save";
    }

    @PostMapping("/create")
    public String saveFilm(Film film) {
        maintenanceService.createFilm(film);
        return "redirect:/maintenance/start";
    }

    /**
     * UPDATE
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        FilmDetailDto filmDetailDto = maintenanceService.getFilmById(id);

        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-edit";
    }

    @PostMapping("/update")
    public String updateFilm(FilmDetailDto filmDetailDto) {
        maintenanceService.updateFilm(filmDetailDto);
        return "redirect:/maintenance/start";
    }

}
