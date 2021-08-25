package com.one.digitalinnovation.bird.controllers;

import com.one.digitalinnovation.bird.dto.request.BirdDTO;
import com.one.digitalinnovation.bird.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.bird.exceptions.BirdNotFoundException;
import com.one.digitalinnovation.bird.services.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping
    public List<BirdDTO> listAll() {
        return birdService.listAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BirdDTO findById(@PathVariable Long id) throws BirdNotFoundException {
        return birdService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid BirdDTO birdDTO) throws BirdNotFoundException {
        return birdService.update(id, birdDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deleteById(@PathVariable Long id) throws BirdNotFoundException{
        return birdService.deleteById(id);
    }
}
