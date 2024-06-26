package dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase;

import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateFilmUseCase {
    @NotNull
    String name;

    public Film toModel(){
       return Film.builder()
                .name(this.getName())
                .build();
    }
}
