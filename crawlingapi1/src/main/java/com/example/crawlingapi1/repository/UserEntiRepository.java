package com.example.crawlingapi1.repository;

import com.example.crawlingapi1.data.Datadb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserEntiRepository extends JpaRepository<Datadb, Long> {

    List<Datadb> findAll();
    Page<Datadb> findByLocation(String location, Pageable pageable);


}