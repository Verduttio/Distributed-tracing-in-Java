package com.example.movieservice.VO.objectResponses;

import com.example.movieservice.VO.Country;
import com.example.movieservice.VO.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorResponse {
    private int directorId;
    private String firstName;
    private String lastName;
    private Country country;
}
