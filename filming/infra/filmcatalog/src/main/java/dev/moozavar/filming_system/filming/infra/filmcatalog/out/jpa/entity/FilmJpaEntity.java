package dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.entity;

import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "film")
public class FilmJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Film toModel(){
        return Film.builder()
                .id(this.getId())
                .name(this.getName())
                .build();
    }

    public static FilmJpaEntity fromModel(Film film){
        return FilmJpaEntity.builder()
                .id(film.getId())
                .name(film.getName())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmJpaEntity that = (FilmJpaEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
