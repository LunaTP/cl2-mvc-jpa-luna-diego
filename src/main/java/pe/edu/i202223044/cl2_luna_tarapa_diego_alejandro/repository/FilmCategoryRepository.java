package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategory;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmCategoryPk;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryPk> {

    @CacheEvict(value = "categories",allEntries = true)
    FilmCategory save(FilmCategory film);

}
