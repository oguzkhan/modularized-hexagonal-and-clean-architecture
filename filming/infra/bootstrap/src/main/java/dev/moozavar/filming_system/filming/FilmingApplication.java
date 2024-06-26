package dev.moozavar.filming_system.filming;

//import dev.moozavar.filming_system.filming.infra.catalog.out.jpa.entity.FilmJpaEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages="dev.moozavar.filming_system.filming.infra.catalog.out.jpa.entity.*",
//basePackageClasses = FilmJpaEntity.class)
public class FilmingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilmingApplication.class, args);
    }

}