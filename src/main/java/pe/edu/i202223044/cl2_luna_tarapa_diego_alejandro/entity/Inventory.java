package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Integer filmId;
    private Integer storeId;
    private Timestamp lastUpdate;
}
