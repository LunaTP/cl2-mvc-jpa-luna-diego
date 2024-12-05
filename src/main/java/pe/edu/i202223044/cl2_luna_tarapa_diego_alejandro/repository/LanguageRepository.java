package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Film;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Language;

import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language,Integer> {

    @Cacheable(value = "languages")
    Iterable<Language> findAll();

    @Cacheable(value = "languages", key = "#id")
    Optional<Language> findById(Integer id);
}
