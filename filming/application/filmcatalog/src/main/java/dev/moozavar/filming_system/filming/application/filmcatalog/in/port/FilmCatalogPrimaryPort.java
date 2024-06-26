package dev.moozavar.filming_system.filming.application.filmcatalog.in.port;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase.CreateFilmUseCase;
import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;

import java.util.List;

public interface FilmCatalogPrimaryPort {
    public Film createFilm(CreateFilmUseCase createFilmUseCase);

    public List<Film> getAllFilms();
}
