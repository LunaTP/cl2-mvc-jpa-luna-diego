package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.dto;

import lombok.Data;
import pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity.Language;

import java.sql.Timestamp;
import java.util.Set;

@Data
public class FilmDetailCategoryDto {
    private String title;
    private String description;
    private Integer releaseYear;
    private Language languageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer  length;
    private Double replacementCost;
    private String rating;
    private Set<String> specialFeatures;
    private Integer categoryCode;
}
