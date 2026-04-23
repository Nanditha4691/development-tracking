package com.developmentTracking.developtrack.controller;

import com.developmentTracking.developtrack.model.Develop;
import com.developmentTracking.developtrack.repository.DevelopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/saveTrack")
public class DevelopController {

    @Autowired
    private DevelopRepository developRepository;

    @GetMapping
    public List<Develop> getAll(){
        return developRepository.findAll();
    }

    @PostMapping
    public Develop submit(@RequestBody Develop saveTrack){
        saveTrack.setCreatedAt(LocalDateTime.now());
        return developRepository.save(saveTrack);
    }

}
