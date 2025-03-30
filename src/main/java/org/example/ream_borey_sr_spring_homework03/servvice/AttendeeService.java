package org.example.ream_borey_sr_spring_homework03.servvice;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.request.AttendeeRequest;

import java.util.List;

public interface AttendeeService {
    List<Attendee> getAllAttendee(@Positive int page, @Positive int size);

    Attendee getAttendeeById(@Positive int id);

    Attendee createAttendee(@Valid AttendeeRequest attendeeRequest);

    Attendee updateAttendeeById(@Valid AttendeeRequest attendeeRequest,@Positive int id);

    Attendee deleteAttendeeById(@Positive int id);
}
