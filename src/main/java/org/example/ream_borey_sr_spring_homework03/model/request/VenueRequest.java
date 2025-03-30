package org.example.ream_borey_sr_spring_homework03.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {
    @NonNull
    @NotBlank
    @Size(
            min = 3, max = 10,message = "Venues must be has 3 to 10 characters"
    )
    private String venueName;
    @NotNull
    @NotBlank
    @Size(
            min = 1, max = 10,message = "Venues location must be has 1 to 10 characters"
    )
    private String location;
}
