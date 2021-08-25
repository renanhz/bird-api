package com.one.digitalinnovation.bird.dto.mapper;

import com.one.digitalinnovation.bird.dto.request.BirdDTO;
import com.one.digitalinnovation.bird.entities.Bird;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BirdMapper {

    Bird toModel(BirdDTO dto);

    BirdDTO toDTO(Bird dto);
}
