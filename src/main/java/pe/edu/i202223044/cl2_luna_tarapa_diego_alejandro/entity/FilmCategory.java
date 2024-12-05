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
public class FilmCategory {
    @EmbeddedId
    private FilmCategoryPk filmCategoryPk;
    private Timestamp lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    @MapsId("filmId")
    private Film film;
}
