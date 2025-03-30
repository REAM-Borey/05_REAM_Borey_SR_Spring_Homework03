package org.example.ream_borey_sr_spring_homework03.repository;

import org.apache.ibatis.annotations.*;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.entity.Event;
import org.example.ream_borey_sr_spring_homework03.model.entity.EventAttendee;
import org.example.ream_borey_sr_spring_homework03.model.request.EventRequest;

import java.util.List;

@Mapper
public interface EventRepository {

    @Select("""
        SELECT * FROM events
        OFFSET #{offset} LIMIT #{size};
        """)
    @Results(id = "EventMapper",value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venue",column = "venue_id",
                    one = @One(select = "org.example.ream_borey_sr_spring_homework03.repository.VenueRepository.getVenueById")),
            @Result(property = "attendee",column = "event_id",
                    many = @Many(select = "org.example.ream_borey_sr_spring_homework03.repository.EventAttendeeRepository.getAttendeesByEventId"))
    })
    List<Event> getAllEvent(int offset, int size);



    @Select("""
        SELECT * FROM events where event_id = #{id}
        """)
    @ResultMap("EventMapper")
    Event getEventById(int id);

    @Insert("""
        INSERT INTO events(event_name,venue_id) VALUES(#{req.name},#{req.venueId})
        """)
    @Results(id = "CreateEventMapper",value = {
            @Result(property = "eventId",column = "event_id"),
            @Result(property = "eventName",column = "event_name"),
            @Result(property = "eventDate",column = "event_date"),
            @Result(property = "venue",column = "venue_id",
                    one = @One(select = "org.example.ream_borey_sr_spring_homework03.repository.VenueRepository.createAttendee")),
            @Result(property = "attendee",column = "event_id",
                    many = @Many(select = "org.example.ream_borey_sr_spring_homework03.repository.EventAttendeeRepository.createEventAttendee"))
    })
    Event createEvent(@Param("req") EventRequest eventRequest);


    @Update("""
            UPDATE events SET event_name= #{req.name},event_date = #{req.date}, venue_id=#{req.venueId} WHERE event_id = #{id};
        """)
    @ResultMap("EventMapper")
    Event updateEventById(int id,@Param("req") EventRequest eventRequest);




    @Delete("""
        DELETE FROM events  WHERE event_id = #{id}
        """)
//    @Results(id = "Event",value = {
//            @Result(property = "eventId",column = "event_id"),
//            @Result(property = "eventName",column = "event_name"),
//            @Result(property = "eventDate",column = "event_date"),
//            @Result(property = "venue",column = "venue_id",
//                    one = @One(select = "org.example.ream_borey_sr_spring_homework03.repository.VenueRepository.deleteVenueById")),
//            @Result(property = "attendee",column = "event_id",
//            many = @Many(select = "org.example.ream_borey_sr_spring_homework03.repository.EventAttendeeRepository.deleteEventAttendeeByEventId"))
//    })
    @ResultMap("EventMapper")
    Event deleteEventById(int id);

    /*

    * */

}
