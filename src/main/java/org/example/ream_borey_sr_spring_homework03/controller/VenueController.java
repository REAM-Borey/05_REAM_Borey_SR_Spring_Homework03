package org.example.ream_borey_sr_spring_homework03.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.example.ream_borey_sr_spring_homework03.model.entity.Venue;
import org.example.ream_borey_sr_spring_homework03.model.request.VenueRequest;
import org.example.ream_borey_sr_spring_homework03.model.response.ApiResponse;
import org.example.ream_borey_sr_spring_homework03.servvice.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/venues")
public class VenueController {
    private final VenueService venueService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenue(@RequestParam(defaultValue = "1") @Positive int page,
                                                                @RequestParam(defaultValue = "10") @Positive int size){
        return ResponseEntity.ok(
                ApiResponse.<List<Venue>>builder()
                        .message("Get all venue is successfully")
                        .payload(venueService.getAllVenue(page,size))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }


    @GetMapping("{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@Param("venue-id") @Positive int id){
        return ResponseEntity.ok(
                ApiResponse.<Venue>builder()
                        .message("Get venue by id is successfully")
                        .payload(venueService.getVenueById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }


    @PostMapping
    public ResponseEntity<ApiResponse<Venue>> createVenue(@RequestBody @Valid VenueRequest venueRequest){
        return ResponseEntity.ok(
                ApiResponse.<Venue>builder()
                        .message("Create venues is successfully")
                        .payload(venueService.createVenue(venueRequest))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @PutMapping("{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> updateVenueById(@Param("venue-id") @Positive int id,@RequestBody @Valid VenueRequest venueRequest){
        return ResponseEntity.ok(
                ApiResponse.<Venue>builder()
                        .message("Update data in venue by id is successfully")
                        .payload(venueService.updateVenueById(id,venueRequest))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }

    @DeleteMapping("{venue-id}")
    public ResponseEntity<ApiResponse<Venue>> deleteVenueById(@Param("venue-id") @Positive int id){
        return ResponseEntity.ok(
                ApiResponse.<Venue>builder()
                        .message("delete venues by id is successfully")
                        .payload(venueService.deleteVenueById(id))
                        .status(HttpStatus.OK)
                        .time(LocalDateTime.now())
                        .build()
        );
    }
}
