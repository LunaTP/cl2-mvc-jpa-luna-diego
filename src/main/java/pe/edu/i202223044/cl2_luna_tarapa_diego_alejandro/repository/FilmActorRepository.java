package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmActor;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.FilmActorPk;

import java.util.List;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorPk> {
    List<FilmActor> findByFilmFilmId(int filmId);
}
