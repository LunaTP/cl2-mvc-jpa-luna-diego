package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailCategoryDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDetailDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto.FilmDto;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.*;
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
        model.addAttribute("filmDetailDto", filmDetailDto);
        return "maintenance-detail";
    }

    /**
     * CREATE
     */
    @GetMapping("/createFilm")
    public String save(Model model) {
        FilmDetailCategoryDto film = new FilmDetailCategoryDto();
        List<Language> listLanguage = maintenanceService.getAllLanguages();
        model.addAttribute("film",film);
        model.addAttribute("listLanguage", listLanguage);
        return "maintenance-save";
    }

    @PostMapping("/create")
    public String saveFilm(FilmDetailCategoryDto film) {
        maintenanceService.createFilm(film, film.getCategoryCode());
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

    /**
     * DELETE
     */

    @PostMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Integer id) {
        maintenanceService.deleteFilm(id);
        return "redirect:/maintenance/start";
    }
}
