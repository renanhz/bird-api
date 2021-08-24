package com.one.digitalinnovation.bird.services;

import com.one.digitalinnovation.bird.repositories.BirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BirdService {

    BirdRepository birdRepository;

    @Autowired
    public BirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }
}
