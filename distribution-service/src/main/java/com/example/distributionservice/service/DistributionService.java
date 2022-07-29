package com.example.distributionservice.service;


import com.example.distributionservice.VO.Country;
import com.example.distributionservice.VO.ResponseTemplateVO;
import com.example.distributionservice.entity.Distribution;
import com.example.distributionservice.repository.DistributionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DistributionService {
    @Autowired
    private DistributionRepository distributionRepository;

    @Autowired
    private RestTemplate restTemplate;


    public Distribution saveDistribution(Distribution distribution) {
        log.info("Inside saveDistribution of DistributionService");
        return distributionRepository.save(distribution);
    }

    public ResponseTemplateVO getDistributionWithCountry(String distributionName) {
        log.info("Inside getDirectorWithCountry method of DirectorService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Distribution distribution = distributionRepository.findByName(distributionName);

        Country country =
                restTemplate.getForObject("http://COUNTRY-SERVICE/countries/" + distribution.getCountry(), Country.class);

//        vo.setDistribution(distribution);

        vo.setName(distribution.getName());
        vo.setAddress(distribution.getAddress());

        vo.setCountry(country);

        return vo;
    }

}
