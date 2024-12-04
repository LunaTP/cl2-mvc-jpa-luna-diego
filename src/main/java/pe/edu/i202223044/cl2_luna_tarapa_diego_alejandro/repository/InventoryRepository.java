package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Inventory;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Integer> {
    List<Inventory> findByFilmId_FilmId(int filmId);

    void deleteByFilmId_FilmId(int filmId);

}
