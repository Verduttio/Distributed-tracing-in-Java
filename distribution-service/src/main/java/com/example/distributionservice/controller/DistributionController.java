package com.example.distributionservice.controller;


import com.example.distributionservice.VO.ResponseTemplateVO;
import com.example.distributionservice.entity.Distribution;
import com.example.distributionservice.service.DistributionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributions")
@Slf4j
public class DistributionController {
    @Autowired
    private DistributionService distributionService;

    @PostMapping("/")
    public Distribution saveDistribution(@RequestBody Distribution distribution) {
        log.info("Inside saveDistribution of DistributionController");
        return distributionService.saveDistribution(distribution);
    }

    @GetMapping("/{name}")
    public ResponseTemplateVO getDistributionWithCountry(@PathVariable("name") String distributionName) {
        log.info("Inside getDistributionWithCountry of DistributionController");
        return distributionService.getDistributionWithCountry(distributionName);
    }


}
