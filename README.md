[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/oguzkhan/modularized-hexagonal-and-clean-architecture/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-tr-red.svg)](https://github.com/oguzkhan/modularized-hexagonal-and-clean-architecture/blob/master/README.tr.md)

## MODULARIZED HEXAGONAL AND CLEAN ARCHITECTURE

#### INTRO

This is a draft project focused on implementing Hexagonal Architecture in a more modularized way than usual, using Java 17 as programming language and Spring Boot as infrastructure framework. The project does not cover Event Driven Architecture (EDA), which is useful for decoupling the modules but not a requirement of hexagonal design. For the purpose of separation of concerns and making learning process more straightforward, EDA will be introduced in upcoming sessions. Project shows the clean separation of `infrastructure code` from the `application core` via `ports` and `adaptors` and removing infrastructure and framework dependencies inside application core. These are the bare minimum requirements of a hexagonal design. Project furthermore divides application core into `application (usecase)` and `domain (entity)` layers as suggested in the Clean Architecture approach. Modularization is taken one step further and layers are divided into feature set modules that serves feature based vertical slicing of the main service. This sample project bundles required services for fulfilling fictive requirements of the film industry. 

#### AUTHOR
This project is authored by `Mehmet Oğuzhan Özavar` for educational and research purposes and licenced under the terms of the MIT license. For any questions, please contact Oğuzhan at `hanoguz@gmail.com`.

#### FURTHER IMPROVEMENTS
Educational material containing the Hexagonal Architecture concept explanations and detailed walkthrough of this sample project are still under development. They will be published when they are ready. In addition to that, Event Driven Architecture, inter feature set dependency management, layer dependency management, unit testing are features to be planned. The community requests will also be prioritized. 

<br>

### PROJECT'S ARCHITECTURE

#### TOP LEVEL MODULES
`filming` maven module represents a service (modular monolith or microservice) containing `application`, `domain` and `infra` layers as sub modules. `infra` module has a special sub module called `bootstrap` which acts as a runtime aggregator of all the modules. Being a Spring Boot application, `bootstrap` module builds all the modules, repackages them and runs the service application. 

#### FEATURE SET MODULES
Each hexagonal architecture layer further divided into sub modules, each of which exposing rest endpoints so that representing a `feature set`. Each feature set, having one sub module under eech layer, can be extracted to a different service module easily by itself or as a combination of other feature sets whenever needed. This approach enables starting with a modular monolith and extracting required microservices at the last responsible moment. Modular structure also enables auditing and supervising the module dependencies via tooling. The outside-in one way dependency policy of hexagonal architecture `(infra -> application -> domain)` would be enforced by tooling in the future versions of this sample project. Let's keep this as a to-do item.

#### INPUT VALIDATION
Definition of the validation rules are part of business logic so that they are not defined inside rest controllers, instead, they are defined inside application layer in a centralized way. For easing the definition of validations and convenience `JSR-303` validation annotations are used inside application layer and execution of validation is delegated to validation adapter inside infra layer. This way, validation logic is kept inside application layer and not duplicated by each entry point inside infrastructure layer. Externalizing execution of validation to infra layer keeps application layer free of validator framework components.

#### LOGGING AND CROSS CUTTING CONCERNS
Business info logging is invoked via Logging Port inside Application Services and performed by Logging Adaptor inside infra modules. In an Event Based Architecture, logging (and possibly other cross cutting concerns) would be isolated from Application Services by subscribing the loggers to the application events published by Application Services.

<br>

### SETUP
1. First, clone the repo into your local environment. 
2. JDK 17+ must be configured as your development environment and system environment.
3. Default project setup needs a Postgresql 12.5+ database server up and running on port `5433`, `filming_admin` and `filming_web` db roles and a `filming` schema with filming_admin being the schema owner to be created beforehands. You can change the DBMS type by changing the bootstrap module configuration as your preference.
4. You can issue `mvn clean install` and `mvn clean spring-boot:run` commands under filming service's bootstrap module folder in order to run the filming service.
5. You can use sample curl commands under [test-execution.bat](.misc/curl/test-execution.bat) to interact with the api.

<br>

### USAGE
- Feel free to adopt the concepts in your project setups. You can also give feedback to author about your thoughts on this architecture and can also report bugs. 
- You may give a star to this repository to save it for further use. By doing so, you will inform author that this kind of material is useful for you and make them continue development.
- Have fun!


