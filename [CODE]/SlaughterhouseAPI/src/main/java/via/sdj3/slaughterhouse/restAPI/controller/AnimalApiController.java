package via.sdj3.slaughterhouse.restAPI.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.service.AnimalService;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AnimalApiController {

    private AnimalService animalService;
    //TODO change to impl if not working

    public AnimalApiController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable int id)
    {
        try {
            return animalService.getById(id).toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/animals")
    public ResponseEntity<Object> create(@RequestBody Animal animal)
    {
        try{
            animalService.create(animal);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
