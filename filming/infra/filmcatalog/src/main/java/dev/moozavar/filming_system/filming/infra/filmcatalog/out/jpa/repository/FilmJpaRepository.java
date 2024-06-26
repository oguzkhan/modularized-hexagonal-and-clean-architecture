package dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.repository;

import dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.entity.FilmJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmJpaRepository extends JpaRepository<FilmJpaEntity, Long> {
}
