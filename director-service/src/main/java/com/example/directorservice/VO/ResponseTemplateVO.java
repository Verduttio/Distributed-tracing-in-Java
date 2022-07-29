package com.example.directorservice.VO;

import com.example.directorservice.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ResponseTemplateVO {
//    private Director director;
//    private Country country;
//}


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private int directorId;
    private String firstName;
    private String lastName;
    private Country country;
}