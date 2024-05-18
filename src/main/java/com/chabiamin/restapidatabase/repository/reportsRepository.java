package com.chabiamin.restapidatabase.repository;

import com.chabiamin.restapidatabase.model.Report;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface reportsRepository extends JpaRepository<Report, Integer> {




    Optional<Report> findById(int id );
}
