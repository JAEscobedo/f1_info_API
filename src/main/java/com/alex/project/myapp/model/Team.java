package com.alex.project.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

@Data
@Entity
@Table(name = "team")
@NoArgsConstructor
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "team")
    @JsonIgnoreProperties({"team"})
    private Set<Driver> drivers;

    @Column(name = "name")
    @NotBlank(message = "Team name is required")
    private String name;

    @Column(name = "principal")
    @NotBlank(message = "Principal is required")
    private String principal;

    @Column(name = "base")
    @NotBlank(message = "Base location is required")
    private String base;
}
