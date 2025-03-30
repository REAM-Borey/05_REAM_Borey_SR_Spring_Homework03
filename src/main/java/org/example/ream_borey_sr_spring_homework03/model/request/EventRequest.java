package org.example.ream_borey_sr_spring_homework03.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jdk.jfr.Timestamp;
import lombok.*;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.entity.Venue;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventRequest {
    @NonNull
    @NotBlank
    @Size(
            min = 3, max = 20,message = "event's name must be has 3 to 20 character"
    )
    private String name;

    private LocalDateTime data;
//    @NonNull
//    @NotBlank
//    @Pattern(
//            regexp = "[1-9]+", message = "Venues id must be has only number start from 1"
//    )
    private Integer venueId;

    private List<Integer> attendeesId;
}
