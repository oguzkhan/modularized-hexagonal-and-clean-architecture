package dev.moozavar.filming_system.filming.infra.filmcatalog.out.adaptor;

import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmRepositoryPort;
import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.entity.FilmJpaEntity;
import dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.repository.FilmJpaRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FilmRepositoryAdaptor implements FilmRepositoryPort {
    private final FilmJpaRepository filmJpaRepository;

    @Override
    public List<Film> findAll() {
        return filmJpaRepository.findAll().stream()
                .map(FilmJpaEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Film> findById(Long id) {
        return filmJpaRepository.findById(id).map(FilmJpaEntity::toModel);
    }

    @Override
    public Film save(Film film) {
        return filmJpaRepository.save(
                FilmJpaEntity.fromModel(film))
                .toModel();
    }

    @Override
    public void deleteById(Long id) {
        filmJpaRepository.deleteById(id);
    }
}
