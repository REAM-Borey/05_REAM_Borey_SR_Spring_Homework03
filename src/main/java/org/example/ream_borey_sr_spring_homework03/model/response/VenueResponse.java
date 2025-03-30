package org.example.ream_borey_sr_spring_homework03.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueResponse {
    private int venueId;
    private String venueName;
    private String location;
}
