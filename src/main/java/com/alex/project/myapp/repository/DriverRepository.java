package com.alex.project.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alex.project.myapp.model.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{

}
