package com.example.distributionservice.VO;

import com.example.distributionservice.entity.Distribution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private String name;
    private String address;
    private Country country;
}
