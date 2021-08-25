package com.one.digitalinnovation.bird.controllers;

import com.one.digitalinnovation.bird.dto.request.BirdDTO;
import com.one.digitalinnovation.bird.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.bird.services.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/bird")
public class BirdController {
    private BirdService birdService;

    @Autowired
    public BirdController(BirdService birdService) {
        this.birdService = birdService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid BirdDTO birdDTO) {
        return birdService.create(birdDTO);
    }
}
