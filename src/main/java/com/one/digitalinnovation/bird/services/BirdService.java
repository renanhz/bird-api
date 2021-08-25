package com.one.digitalinnovation.bird.services;

import com.one.digitalinnovation.bird.dto.mapper.BirdMapper;
import com.one.digitalinnovation.bird.dto.request.BirdDTO;
import com.one.digitalinnovation.bird.dto.response.MessageResponseDTO;
import com.one.digitalinnovation.bird.entities.Bird;
import com.one.digitalinnovation.bird.repositories.BirdRepository;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private MessageResponseDTO createMessageResponse(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }
}
