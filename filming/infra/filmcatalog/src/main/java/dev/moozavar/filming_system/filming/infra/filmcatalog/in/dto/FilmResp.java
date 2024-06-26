package dev.moozavar.filming_system.filming.infra.filmcatalog.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FilmResp {

    @JsonProperty
    Long id;

    @JsonProperty
    String name;

    public static FilmResp fromModel(Film film){
        return FilmResp.builder()
                .id(film.getId())
                .name(film.getName())
                .build();
    }
}
