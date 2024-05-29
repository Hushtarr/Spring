package org.Spring_Data_III.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.Spring_Data_III.enums.MovieState;
import org.Spring_Data_III.enums.MovieType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity
    {
    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition="TEXT")
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",    //third table create by spring for joining the two tables
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;
    }

/*
The @JoinTable annotation is used to specify the name of the join table
that will be created by Spring Data JPA to store the relationships
between the Movie and Genre entities. The joinColumns attribute specifies
the foreign key column in the join table that references the Movie table,
and the inverseJoinColumns attribute specifies the foreign key column
in the join table that references the Genre table.*/