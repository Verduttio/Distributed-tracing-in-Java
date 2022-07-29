package com.example.directorservice.controller;


import com.example.directorservice.VO.ResponseTemplateVO;
import com.example.directorservice.entity.Director;
import com.example.directorservice.service.DirectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/directors")
@Slf4j
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @PostMapping("/")
    public Director saveDirector(@RequestBody Director director) {
        log.info("Inside saveDirector method of DirectorController");
        return directorService.saveDirector(director);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getDirectorWithCountry(@PathVariable("id") int directorId) {
        log.info("Inside getDirectorWithCountry method of DirectorController");
        return directorService.getDirectorWithCountry(directorId);
    }
}
