package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto;

import java.sql.Timestamp;
import java.util.Set;

public record FilmDetailDto(Integer filmId,
                            String title,
                            String description,
                            Integer releaseYear,
                            Integer languageId,
                            String languageName,
                            Integer rentalDuration,
                            Double rentalRate,
                            Integer  length,
                            Double replacementCost,
                            String rating,
                            Set<String> specialFeatures,
                            Timestamp lastUpdate) {
}
