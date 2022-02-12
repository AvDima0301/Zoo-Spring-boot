package app.mapper;

import app.dto.Animal;
import app.entities.AnimalEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface AnimalMapper {
    AnimalEntity AnimalToAnimalEntity(Animal animal);

}
