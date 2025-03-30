package org.example.ream_borey_sr_spring_homework03.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendee {
    private int id;
    private String name;
    private String email;
}
