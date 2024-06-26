package dev.moozavar.filming_system.filming.application.filmcatalog.in.service;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase.CreateFilmUseCase;
import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmValidationPort;
import dev.moozavar.filming_system.filming.application.filmcatalog.in.port.FilmCatalogPrimaryPort;
import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmRepositoryPort;
import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import dev.moozavar.filming_system.filming.domain.common.exception.BadRequestException;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FilmCatalogService implements FilmCatalogPrimaryPort {
    private final FilmRepositoryPort filmRepositoryPort;
    private final FilmValidationPort filmValidationPort;

    @Override
    public Film createFilm(CreateFilmUseCase createFilmUseCase) {
        validateUseCase(createFilmUseCase);
        return filmRepositoryPort.save(createFilmUseCase.toModel());
    }

    @Override
    public List<Film> getAllFilms() {
        return filmRepositoryPort.findAll();
    }

    private void validateUseCase(CreateFilmUseCase createFilmUseCase) {
        String validationResult = filmValidationPort.validate(createFilmUseCase);
        if(!validationResult.isEmpty())
            throw new BadRequestException(validationResult);
    }
}
