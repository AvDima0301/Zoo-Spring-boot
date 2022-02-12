package app.mapper;

import app.dto.Animal;
import app.entities.AnimalEntity;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-29T13:38:30+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_291 (Oracle Corporation)"
)
@Component
public class AnimalMapperImpl implements AnimalMapper {

    @Override
    public AnimalEntity AnimalToAnimalEntity(Animal animal) {
        if ( animal == null ) {
            return null;
        }

        AnimalEntity animalEntity = new AnimalEntity();

        animalEntity.setName( animal.getName() );

        return animalEntity;
    }
}
