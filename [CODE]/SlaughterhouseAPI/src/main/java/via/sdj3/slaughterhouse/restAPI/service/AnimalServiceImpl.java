package via.sdj3.slaughterhouse.restAPI.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.model.AnimalDTO;
import via.sdj3.slaughterhouse.restAPI.repository.AnimalRepository;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public Animal create(AnimalDTO dto) throws Exception {
        if(dto!=null) {
            return animalRepository.create(dto);
        }
        throw new Exception("Animal cannot be null.");
    }

    @Override
    public Animal getById(int regId) throws Exception {
        if (regId >= 1) {
            return animalRepository.getById(regId);
        }
        throw new Exception("ID has to be a positive integer.");
    }

    @Override
    public ArrayList<Animal> getByOrigin(String origin) throws Exception {
        if(origin!=null || !origin.equals(""))
        {
            ArrayList<Animal> animals = animalRepository.getAll();
            ArrayList<Animal> animalsByOrigin = new ArrayList<>();
            animals.forEach(animal ->{
                if(origin.equals(animal.getOrigin()))
                {
                    animalsByOrigin.add(animal);
                }
            } );
            return animalsByOrigin;
        }
        throw new Exception("Origin cannot be null or empty");
    }

    //TODO: As previous todos: Add missing methods.
}
