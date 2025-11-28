package com.alex.project.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;

    @Column(name = "principal")
    private String principal;

    @Column(name = "base")
    private String base;
}
