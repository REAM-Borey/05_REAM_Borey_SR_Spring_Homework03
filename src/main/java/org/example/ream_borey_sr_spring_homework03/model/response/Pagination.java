package org.example.ream_borey_sr_spring_homework03.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {
    private int elements;
    private int page;
    private int pageSize;
    private int totalPages;
}
