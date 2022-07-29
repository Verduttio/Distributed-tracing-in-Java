package com.example.movieservice.VO.objectResponses;


import com.example.movieservice.VO.Country;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionResponse {
    private String name;
    private String address;
    private Country country;
}


