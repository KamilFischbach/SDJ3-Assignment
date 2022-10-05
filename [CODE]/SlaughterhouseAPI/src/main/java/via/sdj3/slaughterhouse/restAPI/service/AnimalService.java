package via.sdj3.slaughterhouse.restAPI.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhouse.restAPI.model.Animal;

@Service
public interface AnimalService {
    void create(Animal animal) throws Exception;
    Animal getById(int regId) throws Exception;
    //TODO: Add the missing methods.
}
