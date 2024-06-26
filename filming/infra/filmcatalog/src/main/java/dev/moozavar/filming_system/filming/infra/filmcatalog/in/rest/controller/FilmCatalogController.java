package dev.moozavar.filming_system.filming.infra.filmcatalog.in.rest.controller;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.port.FilmCatalogPrimaryPort;
import dev.moozavar.filming_system.filming.domain.filmcatalog.model.Film;
import dev.moozavar.filming_system.filming.infra.filmcatalog.in.dto.CreateFilmCmd;
import dev.moozavar.filming_system.filming.infra.filmcatalog.in.dto.FilmResp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/films")
class FilmCatalogController {
    private final FilmCatalogPrimaryPort filmCatalogPrimaryPort;

    @PostMapping
    public ResponseEntity<FilmResp> createFilm(@RequestBody CreateFilmCmd cmd){
        Film film = filmCatalogPrimaryPort.createFilm(cmd.toUseCase());
        return new ResponseEntity<>(
                FilmResp.fromModel(film),
                HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<FilmResp>> getAllFilms(){
        return ResponseEntity.ok(
                filmCatalogPrimaryPort.getAllFilms().stream()
                        .map(FilmResp::fromModel)
                        .collect(Collectors.toList()));
    }



}
