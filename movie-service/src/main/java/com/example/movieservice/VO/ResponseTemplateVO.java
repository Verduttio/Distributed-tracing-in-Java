package com.example.movieservice.VO;

import com.example.movieservice.VO.objectResponses.DirectorResponse;
import com.example.movieservice.VO.objectResponses.DistributionResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private int movieId;
    private String title;
    private Genre genre;
    private int year;
    private DirectorResponse director;
    private DistributionResponse distribution;
}
