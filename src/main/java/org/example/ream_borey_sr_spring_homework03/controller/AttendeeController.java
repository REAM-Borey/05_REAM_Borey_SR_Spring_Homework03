package org.example.ream_borey_sr_spring_homework03.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.example.ream_borey_sr_spring_homework03.exception.NotFoundException;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.request.AttendeeRequest;
import org.example.ream_borey_sr_spring_homework03.model.response.ApiResponse;
import org.example.ream_borey_sr_spring_homework03.servvice.AttendeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/attendees")
public class AttendeeController {
    private final AttendeeService attendeeService;
    private Attendee attendee;

    @GetMapping
    private ResponseEntity<ApiResponse<List<Attendee>>> getAllAttendee(@RequestParam(defaultValue = "1") @Positive int page,
                                                                       @RequestParam(defaultValue = "10") @Positive int size){
        return ResponseEntity.ok(
                ApiResponse.<List<Attendee>>builder()
                        .message("Get all attendee is successfully")
                        .payload(attendeeService.getAllAttendee(page,size))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }


    @GetMapping("{attendee-id}")
    private ResponseEntity<?> getAttendeeById(@Param("attendee-id") @Positive int id){
        return ResponseEntity.ok(
                ApiResponse.<Attendee>builder()
                        .message("Get attendee by id is successfully")
                        .payload(attendeeService.getAttendeeById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );

    }
    @PostMapping
    private ResponseEntity<ApiResponse<Attendee>> createAttendee(@RequestBody @Valid AttendeeRequest attendeeRequest){
        return ResponseEntity.ok(
                ApiResponse.<Attendee>builder()
                        .message("Create attendee is successfully")
                        .payload(attendeeService.createAttendee(attendeeRequest))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("{attendee-id}")
    private ResponseEntity<ApiResponse<Attendee>> updateAttendeeById(@RequestBody @Valid AttendeeRequest attendeeRequest,@Positive int id){
        return ResponseEntity.ok(
                ApiResponse.<Attendee>builder()
                        .message("Update attendee is successfully")
                        .payload(attendeeService.updateAttendeeById(attendeeRequest,id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("{attendee-id}")
    private ResponseEntity<ApiResponse<Attendee>> deleteAttendeeById(@Param("attendee-id") @Positive int id){
        return ResponseEntity.ok(
                ApiResponse.<Attendee>builder()
                        .message("deleted attendee by id is successfully")
                        .payload(attendeeService.deleteAttendeeById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }


}
