package pe.edu.i202223044.cl2_luna_tarapa_diego_alejandro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;
    private String title;
    private String description;
    private Integer releaseYear;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "language_id")
    private Language languageId;

    private Integer originalLanguageId;
    private Integer rentalDuration;
    private Double rentalRate;
    private Integer length;
    private Double replacementCost;
    private String rating;
    private String specialFeatures;
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "film", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FilmActor> filmActors;

    @OneToMany(mappedBy = "film", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FilmCategory> filmCategories;

    @OneToMany(mappedBy = "filmId", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Inventory> inventories;



}
