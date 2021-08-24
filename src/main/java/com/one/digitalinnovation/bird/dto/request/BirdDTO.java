package com.one.digitalinnovation.bird.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BirdDTO {

    private Long id;

    @NotEmpty
    @Size(max = 50)
    private String family;

    @NotEmpty
    @Size(max = 100)
    private String species;

    @NotEmpty
    @Size(max = 50)
    private String commonName;

    @NotEmpty
    @Size(max = 200)
    private String feedingInfo;

    @NotEmpty
    @Size(max = 300)
    private String description;
}
