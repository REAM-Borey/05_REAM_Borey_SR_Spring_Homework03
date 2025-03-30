package org.example.ream_borey_sr_spring_homework03.servvice.serviceImpl;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.example.ream_borey_sr_spring_homework03.exception.NotFoundException;
import org.example.ream_borey_sr_spring_homework03.model.entity.Event;
import org.example.ream_borey_sr_spring_homework03.model.request.EventRequest;
import org.example.ream_borey_sr_spring_homework03.repository.EventAttendeeRepository;
import org.example.ream_borey_sr_spring_homework03.repository.EventRepository;
import org.example.ream_borey_sr_spring_homework03.servvice.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private Event event;
    private final EventAttendeeRepository eventAttendeeRepository;

    @Override
    public List<Event> getAllEvent(@Positive int page,@Positive int size) {
        List<Event>event = eventRepository.getAllEvent(page,size);
        if (event == null || event.equals(0)){
            throw new NotFoundException("Event doesn't has in");
        }
        int offset = (page - 1) * size;
        return eventRepository.getAllEvent(offset,size);
    }

    @Override
    public Event getEventById(@Positive int id) {
        event = eventRepository.getEventById(id);
        if (event == null || event.equals(0)){
            throw new NotFoundException("Invalid id");
        }
        return eventRepository.getEventById(id);
    }

    @Override
    public Event createEvent(@Valid EventRequest eventRequest) {
        event = eventRepository.createEvent(eventRequest);
        if (!eventRequest.getAttendeesId().isEmpty()) {
            for (int attendeeId : eventRequest.getAttendeesId()) {
                eventAttendeeRepository.createEventAttendee(event.getEventId(),attendeeId);
            }
        }
        return eventRepository.getEventById(event.getEventId());
    }

    @Override
    public Event updateEventById(@Positive int id,@Valid EventRequest eventRequest) {
        event = eventRepository.updateEventById(id,eventRequest);
        if (event.getEventId() == 0 ||event.equals(null) ){
            throw new NotFoundException("Invalid id");
        }
        return eventRepository.updateEventById(id,eventRequest);
    }

    @Override
    public Event deleteEventById(int id) {
        event = eventRepository.deleteEventById(id);
        if (event == null){
            throw new NotFoundException("Invalid id");
        }
        return eventRepository.deleteEventById(id);
    }
}
