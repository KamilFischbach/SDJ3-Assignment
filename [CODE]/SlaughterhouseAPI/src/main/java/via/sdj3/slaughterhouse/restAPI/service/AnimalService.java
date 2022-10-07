package via.sdj3.slaughterhouse.restAPI.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.model.AnimalDTO;
import via.sdj3.slaughterhouse.restAPI.model.DateDTO;

import java.util.ArrayList;

@Service
public interface AnimalService {
    Animal create(AnimalDTO dto) throws Exception;
    Animal getById(int regId) throws Exception;
    ArrayList<Animal> getByOrigin(String origin) throws Exception;
    ArrayList<Animal> getByDate(DateDTO dto) throws Exception;

    //TODO: Add the missing methods.
}
