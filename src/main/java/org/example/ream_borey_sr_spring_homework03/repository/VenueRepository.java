package org.example.ream_borey_sr_spring_homework03.repository;

import org.apache.ibatis.annotations.*;
import org.example.ream_borey_sr_spring_homework03.model.entity.Venue;
import org.example.ream_borey_sr_spring_homework03.model.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {


    @Select("""
        SELECT * FROM venues
        OFFSET #{offset} LIMIT #{size}
        """)
    @Results(id = "VenueMapper",value = {
        @Result(property = "venueId",column = "venue_id"),
        @Result(property = "name",column = "venue_name"),
        @Result(property = "location",column = "location"),
    })
    List<Venue> getAllVenue(int offset,int size);

    @Select("""
        SELECT * FROM venues where venue_id =#{id}
        """)
    @ResultMap("VenueMapper")
    Venue getVenueById(int id);

    @Insert("""
        INSERT INTO venues(venue_name,location) values (#{req.venueName},#{req.location})
        RETURNING *;
        """)
    @ResultMap("VenueMapper")
    Venue createVenue(@Param("req") VenueRequest venueRequest);

    @Update("""
        update venues set venue_name = #{req.venueName},location = #{req.location} where venue_id = #{id}
        RETURNING *;
        """)
    @ResultMap("VenueMapper")
    Venue updateVenueById(int id,@Param("req") VenueRequest venueRequest);

    @Delete("""
        delete from venues where venue_id = #{id}
        """)
    @ResultMap("VenueMapper")
    Venue deleteVenueById(int id);
}
