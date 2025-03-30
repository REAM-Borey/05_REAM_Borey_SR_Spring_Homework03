package org.example.ream_borey_sr_spring_homework03.repository;

import org.apache.ibatis.annotations.*;
import org.example.ream_borey_sr_spring_homework03.model.entity.Attendee;
import org.example.ream_borey_sr_spring_homework03.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Select("""
        SELECT * FROM attendees
        OFFSET #{offset} LIMIT #{size}
        """)
    @Results(id = "AttendeeMapper",value = {
            @Result(property = "id",column = "attendee_id"),
            @Result(property = "name",column = "attendee_name")
    })
    List<Attendee> getAllAttendee(int offset,int size);


    @Select("""
        SELECT * FROM attendees where attendee_id = #{id}
        """)
    @ResultMap("AttendeeMapper")
    Attendee getAttendeeById(int id);

    @Insert("""
        INSERT INTO attendees(attendee_name,email) values (#{req.name},#{req.email})
        RETURNING *;
        """)
    @ResultMap("AttendeeMapper")
    Attendee createAttendee(@Param("req") AttendeeRequest attendeeRequest);


    @Update("""
        UPDATE attendees SET attendee_name= #{req.name},email = #{req.email} WHERE attendee_id = #{id}
        RETURNING *;
        """)
    @ResultMap("AttendeeMapper")
    Attendee updateAttendeeById(@Param("req") AttendeeRequest attendeeRequest, int id);

    @Delete("""
        delete from attendees where attendee_id = #{id}
        """)
    @ResultMap("AttendeeMapper")
    Attendee deleteAttendeeById(int id);
}
