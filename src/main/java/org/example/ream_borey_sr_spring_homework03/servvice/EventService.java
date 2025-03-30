package org.example.ream_borey_sr_spring_homework03.servvice;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.ream_borey_sr_spring_homework03.model.entity.Event;
import org.example.ream_borey_sr_spring_homework03.model.request.EventRequest;

import java.util.List;

public interface EventService {
    List<Event> getAllEvent(@Positive int page,@Positive int size);

    Event getEventById(@Positive int id);

    Event createEvent(EventRequest eventRequest);

    Event updateEventById(@Positive int id,@Valid EventRequest eventRequest);

    Event deleteEventById(@Positive int id);
}
