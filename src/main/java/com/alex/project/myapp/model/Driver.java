package com.alex.project.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "First name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotBlank(message = "Last name is required")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnoreProperties({"drivers"})
    @NotNull(message="Team is required")
    private Team team;

    @Column(name = "nationality")
    @NotBlank(message = "Nationality is required")
    private String nationality;

    @Column(name = "driver_number")
    @Min(value = 1, message = "Driver number must be at least 1")
    private Integer driverNumber;

    @Column(name = "season")
    @NotNull(message = "Season is required")
    private Integer season;

    @Column(name = "driver_championship_points")
    private Integer driverChampionshipPoints;

    @Column(name = "driver_championship_position")
    private Integer driverChampionshipPosition;
}
