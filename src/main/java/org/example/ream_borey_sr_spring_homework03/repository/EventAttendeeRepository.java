package org.example.ream_borey_sr_spring_homework03.repository;

import org.apache.ibatis.annotations.*;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;

import java.util.List;

@Mapper
public interface EventAttendeeRepository {


    @Select("""
            SELECT * FROM  event_attendee ea INNER JOIN attendees ad ON ea.attendee_id = ad.attendee_id WHERE event_id =#{eventId};
            """)
    @Results(id = "attendeeMapper", value = {
            @Result(property = "id", column = "attendee_id"),
            @Result(property = "name", column = "attendee_name")
    })
     List<Attendee> getAttendeesByEventId(int eventId);

    @Insert("""
            INSERT INTO event_attendee (event_id, attendee_id)
            VALUES (#{event_id}, #{attendee_id});
            """)
    void createEventAttendee(@Param("event_id") int eventId, @Param("attendee_id") int attendeeId);

    @Delete("""
            DELETE FROM event_attendee
            WHERE event_id = #{event_id};
            """)
    void deleteEventAttendeeByEventId(@Param("event_id") int eventId);

}
