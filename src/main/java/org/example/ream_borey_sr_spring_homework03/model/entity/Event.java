package org.example.ream_borey_sr_spring_homework03.model.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event {
    private int eventId;
    private String eventName;
    private Instant eventDate;
    private Venue venue;
    private List<Attendee> attendee;
}
