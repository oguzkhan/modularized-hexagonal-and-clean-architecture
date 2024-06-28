package dev.moozavar.filming_system.filming.infra.filmcatalog.in.config;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.port.FilmCatalogPrimaryPort;
import dev.moozavar.filming_system.filming.application.filmcatalog.in.service.FilmCatalogService;
import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmRepositoryPort;
import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmValidationPort;
import dev.moozavar.filming_system.filming.infra.filmcatalog.out.adaptor.FilmRepositoryAdaptor;
import dev.moozavar.filming_system.filming.infra.filmcatalog.out.adaptor.FilmValidationAdaptor;
import dev.moozavar.filming_system.filming.infra.filmcatalog.out.jpa.repository.FilmJpaRepository;
import jakarta.validation.Validator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PrimaryPortConfig {

    @Bean
    FilmRepositoryPort filmRepositoryPort(final FilmJpaRepository filmJpaRepository){
        return new FilmRepositoryAdaptor(filmJpaRepository);
    }

    @Bean
    FilmValidationPort filmValidationPort(final Validator validator){
        return new FilmValidationAdaptor(validator);
    }

    @Bean
    FilmCatalogPrimaryPort filmCatalogPrimaryPort(final FilmRepositoryPort filmRepositoryPort, final FilmValidationPort filmValidationPort){
        return new FilmCatalogService(filmRepositoryPort, filmValidationPort);
    }

}
