package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Inventory;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory,Integer> {
}
