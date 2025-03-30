package org.example.ream_borey_sr_spring_homework03.servvice.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.example.ream_borey_sr_spring_homework03.exception.NotFoundException;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.entity.Venue;
import org.example.ream_borey_sr_spring_homework03.model.request.VenueRequest;
import org.example.ream_borey_sr_spring_homework03.repository.VenueRepository;
import org.example.ream_borey_sr_spring_homework03.servvice.VenueService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class VenueServiceImpl implements VenueService {
    private final VenueRepository venueRepository;
    private Venue venue;
    @Override
    public List<Venue> getAllVenue(int page, int size) {
        List<Venue> venue = venueRepository.getAllVenue(page, size);
        if (venue == null){
            throw new NotFoundException("Invalid venues in here");
        }
        int offset =(page - 1) * size;
        return venueRepository.getAllVenue(offset,size);
    }

    @Override
    public Venue getVenueById(int id) {
        venue = venueRepository.getVenueById(id);
        if (venue == null){
            throw new NotFoundException("Invalid id's venues");
        }
        return venueRepository.getVenueById(id);
    }

    @Override
    public Venue createVenue(VenueRequest venueRequest) {
        return venueRepository.createVenue(venueRequest);
    }

    @Override
    public Venue updateVenueById(int id, VenueRequest venueRequest) {
        venue = venueRepository.updateVenueById(id,venueRequest);
        if (venue == null){
            throw new NotFoundException("Invalid venues id");
        }
        return venueRepository.updateVenueById(id,venueRequest);
    }

    @Override
    public Venue deleteVenueById(int id) {
        venue = venueRepository.deleteVenueById(id);
        if (venue == null || venue.equals(0)){
            throw new NotFoundException("Invalid id");
        }
        return venueRepository.deleteVenueById(id);
    }
}
