package com.example.directorservice.service;

import com.example.directorservice.VO.Country;
import com.example.directorservice.VO.ResponseTemplateVO;
import com.example.directorservice.entity.Director;
import com.example.directorservice.repository.DirectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Director saveDirector(Director director) {
        log.info("Inside saveDirector method of DirectorService");
        return directorRepository.save(director);
    }

    public ResponseTemplateVO getDirectorWithCountry(int directorId) {
        log.info("Inside getDirectorWithCountry method of DirectorService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Director director = directorRepository.findByDirectorId(directorId);

        Country country =
               restTemplate.getForObject("http://COUNTRY-SERVICE/countries/" + director.getCountry(), Country.class);

//        vo.setDirector(director);

        vo.setDirectorId(directorId);
        vo.setFirstName(director.getFirstName());
        vo.setLastName(director.getLastName());
        vo.setCountry(country);

        return vo;
    }
}
