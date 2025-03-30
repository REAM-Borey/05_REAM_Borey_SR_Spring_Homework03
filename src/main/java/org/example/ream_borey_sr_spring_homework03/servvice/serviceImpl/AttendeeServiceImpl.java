package org.example.ream_borey_sr_spring_homework03.servvice.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.ream_borey_sr_spring_homework03.exception.NotFoundException;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.request.AttendeeRequest;
import org.example.ream_borey_sr_spring_homework03.repository.AttendeeRepository;
import org.example.ream_borey_sr_spring_homework03.servvice.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepository attendeeRepository;
    private Attendee attendee;

    @Override
    public List<Attendee> getAllAttendee(int page ,int size) {
        List<Attendee> allAttendee  = attendeeRepository.getAllAttendee(page, size);
        if (allAttendee == null){
            throw new NotFoundException("The attendee doesn't has in database");
        }
        int offset = (page -1 ) * size;
        return attendeeRepository.getAllAttendee(offset,size);
    }

    @Override
    public Attendee getAttendeeById(int id) {
        attendee = attendeeRepository.getAttendeeById(id);
        if (attendee == null){
            throw new NotFoundException("The attendee id "+id+" has not been founded");
        }
        return attendeeRepository.getAttendeeById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(attendee);
    }

    @Override
    public Attendee createAttendee(AttendeeRequest attendeeRequest) {
        attendee = attendeeRepository.createAttendee(attendeeRequest);
        if (attendee.getEmail().equals("")|| attendee.getName().equals("")){
            throw new NotFoundException("must not be blank");
        }
        return attendeeRepository.createAttendee(attendeeRequest);
    }

    @Override
    public Attendee updateAttendeeById(AttendeeRequest attendeeRequest, int id) {
        attendee = attendeeRepository.updateAttendeeById(attendeeRequest,id);
        if (attendee == null){
            throw new NotFoundException("bad request");
        }
        return attendeeRepository.updateAttendeeById(attendeeRequest,id);
    }

    @Override
    public Attendee deleteAttendeeById(int id) {
        attendee = attendeeRepository.deleteAttendeeById(id);
        if (attendee == null || attendee.equals(0)){
            throw new NotFoundException("Invalid id");
        }
        return attendeeRepository.deleteAttendeeById(id);
    }
}
