package com.one.digitalinnovation.bird.services;

import com.one.digitalinnovation.bird.dto.mapper.BirdMapper;
import com.one.digitalinnovation.bird.dto.request.BirdDTO;
import com.one.digitalinnovation.bird.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.bird.entities.Bird;
import com.one.digitalinnovation.bird.exceptions.BirdNotFoundException;
import com.one.digitalinnovation.bird.repositories.BirdRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BirdService {

    private BirdRepository birdRepository;

    private BirdMapper birdMapper;

    @Autowired
    public BirdService(BirdRepository birdRepository, BirdMapper birdMapper) {
        this.birdRepository = birdRepository;
        this.birdMapper = birdMapper;
    }

    public MessageResponseDTO create(BirdDTO birdDTO) {
        Bird bird = birdMapper.toModel(birdDTO);
        Bird savedBird = birdRepository.save(bird);

        MessageResponseDTO messageResponse = createMessageResponse("Bird created with ID: ", savedBird.getId());

        return messageResponse;
    }

    public List<BirdDTO> listAll() {
        List<Bird> birds = birdRepository.findAll();
        return birds.stream().map(birdMapper::toDTO).collect(Collectors.toList());
    }

    public BirdDTO findById(Long id) throws BirdNotFoundException {
        Bird bird = birdRepository.findById(id).orElseThrow(() -> new BirdNotFoundException(id));

        return birdMapper.toDTO(bird);
    }

    public MessageResponseDTO update(Long id, BirdDTO birdDTO) throws BirdNotFoundException{
        birdRepository.findById(id).orElseThrow(() -> new BirdNotFoundException(id));

        Bird updatedBird = birdMapper.toModel(birdDTO);
        Bird savedBird = birdRepository.save(updatedBird);

        return createMessageResponse("Bird updated with ID: ", savedBird.getId());
    }

    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}
