package com.alex.project.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "driver")
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"drivers"})
    private Team team;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "driver_number")
    private Integer driverNumber;

    @Column(name = "season")
    private Integer season;

    @Column(name = "driver_championship_points")
    private Integer driverChampionshipPoints;

    @Column(name = "driver_championship_position")
    private Integer driverChampionshipPosition;
}
