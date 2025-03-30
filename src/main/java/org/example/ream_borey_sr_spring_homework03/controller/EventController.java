package org.example.ream_borey_sr_spring_homework03.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.example.ream_borey_sr_spring_homework03.model.entity.Event;
import org.example.ream_borey_sr_spring_homework03.model.request.EventRequest;
import org.example.ream_borey_sr_spring_homework03.model.response.ApiResponse;
import org.example.ream_borey_sr_spring_homework03.servvice.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/events")
public class EventController {
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Event>>> getAllEvent(@RequestParam(defaultValue = "1") int page,
                                                                @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(
                ApiResponse.<List<Event>>builder()
                        .message("Get all event is successfully")
                        .payload(eventService.getAllEvent(page,size))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }
    @GetMapping("{event-id}")
    public ResponseEntity<ApiResponse<Event>> getEventById(@Param("event-id") int id){
        return ResponseEntity.ok(
                ApiResponse.<Event>builder()
                        .message("Get event by id is successfully")
                        .payload(eventService.getEventById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Event>> createEvent(@RequestBody EventRequest eventRequest){
        return ResponseEntity.ok(
                ApiResponse.<Event>builder()
                        .message("create event is successfully")
                        .payload(eventService.createEvent(eventRequest))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("{event-id}")
    public ResponseEntity<ApiResponse<Event>> updateEventById(@Param("event-id") int id, @RequestBody EventRequest eventRequest){
        return ResponseEntity.ok(
                ApiResponse.<Event>builder()
                        .message("Update event by id is successfully")
                        .payload(eventService.updateEventById(id,eventRequest))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }
    @DeleteMapping("{event-id}")
    public ResponseEntity<ApiResponse<Event>> deleteEventById(@Param("event-id") int id){
        return ResponseEntity.ok(
                ApiResponse.<Event>builder()
                        .message("deleted event by id is successfully")
                        .payload(eventService.deleteEventById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }
}
