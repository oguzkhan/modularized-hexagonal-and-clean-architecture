[![en](https://img.shields.io/badge/lang-en-blue.svg)](https://github.com/oguzkhan/modularized-hexagonal-filming-system/blob/master/README.md)
[![es](https://img.shields.io/badge/lang-tr-red.svg)](https://github.com/oguzkhan/modularized-hexagonal-filming-system/blob/master/README.tr.md)

## MODÜLER HEXAGONAL ve CLEAN MİMARİ
<br>
This is a draft project focused on implementing hexagonal architecture in a more modularized way than usual using Java 17 and Spring Boot. The project at hand bundles required services as a draft for fulfilling a fictive requirements of the film industry. This project is authored by Mehmet Oğuzhan Özavar for educational purposes and licenced under the terms of the MIT license. For any questions, please contact Oğuzhan at hanoguz@gmail.com.
<br>

### GENERAL ARCHITECTURE

`filming` maven module represents a service (modular monolith or microservice) containing `application`, `domain` and `infra` layers as sub modules. `infra` module has a special sub module called `bootstrap` which acts as a runtime aggregator of all the modules. Being a Spring Boot application, `bootstrap` module builds all the modules and repackages them. Each hexagonal architecture layer further divided into sub modules, each of which exposing rest endpoints so that representing a $${\color{green}Green}$$ **feature set**. Each feature set, having one sub module under application, module and infra layers, can be extracted to a different service module easily by itself or as a combination of other feature sets whenever needed. This approach enables starting with a modular monolith and extracting required microservices at the last responsible moment. Modular structure also enables auditing and supervising the module dependencies via tooling. The outside-in one way dependency policy of hexagonal architecture (infra -> application -> domain) would be enforced by tooling in the future versions of this sample project.


