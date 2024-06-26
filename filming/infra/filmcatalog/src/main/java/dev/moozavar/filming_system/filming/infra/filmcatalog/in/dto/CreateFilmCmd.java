package dev.moozavar.filming_system.filming.infra.filmcatalog.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase.CreateFilmUseCase;

public class CreateFilmCmd {

    @JsonProperty
    String name;

    public CreateFilmUseCase toUseCase(){
        return CreateFilmUseCase.builder()
                .name(this.name)
                .build();
    }
}
