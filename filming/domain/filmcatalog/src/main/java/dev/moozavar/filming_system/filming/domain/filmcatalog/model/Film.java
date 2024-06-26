package dev.moozavar.filming_system.filming.domain.filmcatalog.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Film {
    Long id;
    String name;
}
