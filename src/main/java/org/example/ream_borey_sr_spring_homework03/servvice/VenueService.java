package org.example.ream_borey_sr_spring_homework03.servvice;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.ream_borey_sr_spring_homework03.model.entity.Venue;
import org.example.ream_borey_sr_spring_homework03.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<Venue> getAllVenue(@Positive int page, @Positive int size);

    Venue getVenueById(@Positive int id);

    Venue createVenue(@Valid VenueRequest venueRequest);

    Venue updateVenueById(@Positive int id, @Valid VenueRequest venueRequest);

    Venue deleteVenueById(@Positive int id);
}
