package org.Spring_Data_III.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity
    {
    @Column(columnDefinition = "DATE")
    private LocalDateTime dateTime;
    /*@ManyToOne annotation is used to establish a relationship between the MovieCinema entity and the Movie entity.
    the ownership of the relationship belongs to the MovieCinema entity.
    This is because the @ManyToOne annotation is used in the MovieCinema entity, */
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
    }
