package org.example.ream_borey_sr_spring_homework03.model.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.apache.ibatis.annotations.Param;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendeeRequest {
    @NonNull
    @NotBlank
    @Size(
            min = 3,max = 10,message = "Attendees name must be between 3 to 10 characters"
    )
    private String name;
    @NonNull
    @NotBlank
    @Email
    private String email;
}
