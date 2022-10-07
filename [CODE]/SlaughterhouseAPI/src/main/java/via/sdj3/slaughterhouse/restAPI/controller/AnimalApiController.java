package via.sdj3.slaughterhouse.restAPI.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.model.AnimalDTO;
import via.sdj3.slaughterhouse.restAPI.service.AnimalService;

import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping
public class AnimalApiController {
    //cd C:\Users\fisch\Documents\GitHub\SDJ3-Assignment\[CODE]\SlaughterhouseAPI
    //mvnw spring-boot:run
    private AnimalService animalService;
    //TODO change to impl if not working

    public AnimalApiController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/getID/{id}")
    //Code was failing because there were two /get requests
    // with PathVariable, and it couldn't distinguish them
    public String getById(@PathVariable int id)
    {
        try {
            Animal animal = animalService.getById(id);
            //return new ResponseEntity<>(animal, HttpStatus.ACCEPTED);
            return animal.toString();
        } catch (Exception e) {
            String error = e.getMessage();
            //return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
            return null;
        }
    }
    @PostMapping("/animals")
    public ResponseEntity<Object> create(@RequestBody AnimalDTO dto)
    {
        try{
            Animal created = animalService.create(dto);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{origin}")
    public ResponseEntity<Object> getByOrigin(@PathVariable String origin)
    {
        try{
            ArrayList<Animal> animals = animalService.getByOrigin(origin);
            return new ResponseEntity<>(animals, HttpStatus.ACCEPTED);
        }
        catch(Exception e) {
            String error = e.getMessage();
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

    }
}
