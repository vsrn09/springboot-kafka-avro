package org.poc.kafka.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.poc.kafka.api.model.Contact;
import org.poc.kafka.api.model.Score;
import org.poc.kafka.api.model.Student;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-30T15:02:14-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.6 (Microsoft)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public org.poc.kafka.avro.model.Student mapStudentApiDataToStudentAvroData(Student student) {
        if ( student == null ) {
            return null;
        }

        org.poc.kafka.avro.model.Student.Builder student1 = org.poc.kafka.avro.model.Student.newBuilder();

        student1.setId( StudentMapper.uuidToString( student.getId() ) );
        student1.setRollNumber( student.getRollNumber() );
        student1.setFirstName( student.getFirstName() );
        student1.setLastName( student.getLastName() );
        student1.setClassName( student.getClassName() );
        student1.setContact( contactToContact( student.getContact() ) );
        student1.setScores( scoreListToScoreList( student.getScores() ) );

        return student1.build();
    }

    protected org.poc.kafka.avro.model.Contact contactToContact(Contact contact) {
        if ( contact == null ) {
            return null;
        }

        org.poc.kafka.avro.model.Contact.Builder contact1 = org.poc.kafka.avro.model.Contact.newBuilder();

        contact1.setEmailId( contact.getEmailId() );
        contact1.setMobile( contact.getMobile() );

        return contact1.build();
    }

    protected org.poc.kafka.avro.model.Score scoreToScore(Score score) {
        if ( score == null ) {
            return null;
        }

        org.poc.kafka.avro.model.Score.Builder score1 = org.poc.kafka.avro.model.Score.newBuilder();

        score1.setSubject( score.getSubject() );
        score1.setMarks( score.getMarks() );

        return score1.build();
    }

    protected List<org.poc.kafka.avro.model.Score> scoreListToScoreList(List<Score> list) {
        if ( list == null ) {
            return null;
        }

        List<org.poc.kafka.avro.model.Score> list1 = new ArrayList<org.poc.kafka.avro.model.Score>( list.size() );
        for ( Score score : list ) {
            list1.add( scoreToScore( score ) );
        }

        return list1;
    }
}
