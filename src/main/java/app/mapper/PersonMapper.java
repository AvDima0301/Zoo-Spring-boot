package app.mapper;

import app.dto.Person;
import app.entities.PersonEntity;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface PersonMapper {
    PersonEntity PersonToPersonEntity(Person person);
}
