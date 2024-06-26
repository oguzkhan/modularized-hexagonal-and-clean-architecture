package dev.moozavar.filming_system.filming.infra.filmcatalog.out.adaptor;

import dev.moozavar.filming_system.filming.application.filmcatalog.in.usecase.CreateFilmUseCase;
import dev.moozavar.filming_system.filming.application.filmcatalog.out.port.FilmValidationPort;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class FilmValidationAdaptor implements FilmValidationPort {

    private final Validator validator;
    @Override
    public String validate(CreateFilmUseCase useCase) {
        Set<ConstraintViolation<CreateFilmUseCase>> violations = validator.validate(useCase);
        return (violations.isEmpty() ? "" : violations.toString());
    }
}
