package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategory;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategoryPk;

import java.util.List;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryPk> {
    List<FilmCategory> findCategoryByFilmFilmId(int filmId);
}
