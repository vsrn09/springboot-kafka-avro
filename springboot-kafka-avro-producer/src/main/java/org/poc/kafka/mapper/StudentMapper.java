package org.poc.kafka.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.poc.kafka.avro.model.Student;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(target = "contactBuilder", ignore = true)
    @Mapping(source = "id", target = "id", qualifiedByName = "uuidToString")
    Student mapStudentApiDataToStudentAvroData(org.poc.kafka.api.model.Student student);

    @Named("uuidToString")
    static String uuidToString(UUID uuid) {
        return uuid != null ? uuid.toString() : null;
    }
}
