package com.example.crawlingapi1.service;
import com.example.crawlingapi1.data.Datadb;
import com.example.crawlingapi1.repository.UserEntiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


import java.util.List;

@Service
@Transactional
public class DataService {

    private UserEntiRepository userRepository;

    @Autowired
    public DataService(UserEntiRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Datadb> getCategories() {
        List<Datadb> userEntities = userRepository.findAll();
        return userEntities;
    }


    public Page<Datadb> getReservationByEmail(String location, Pageable pageable) {
        return (Page<Datadb>) userRepository.findByLocation(location,pageable);
    }


}