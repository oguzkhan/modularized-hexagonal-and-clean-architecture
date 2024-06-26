package dev.moozavar.filming_system.filming.application.filmcatalog.out.port;

import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmRepositoryPort {

    List<Film> findAll();

    Optional<Film> findById(Long id);

    Film save(Film film);

    void deleteById(Long id);
}
