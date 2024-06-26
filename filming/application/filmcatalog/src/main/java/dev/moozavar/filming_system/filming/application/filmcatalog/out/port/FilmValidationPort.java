package dev.moozavar.filming_system.filming.application.filmcatalog.out.port;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase.CreateFilmUseCase;

public interface FilmValidationPort {
    public String validate(CreateFilmUseCase useCase);
}
