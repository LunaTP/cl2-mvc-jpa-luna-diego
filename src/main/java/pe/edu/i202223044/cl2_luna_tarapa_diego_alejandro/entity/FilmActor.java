package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmActor {
    @EmbeddedId
    private FilmActorPk filmActorPk;
    private Timestamp lastUpdate;
}
