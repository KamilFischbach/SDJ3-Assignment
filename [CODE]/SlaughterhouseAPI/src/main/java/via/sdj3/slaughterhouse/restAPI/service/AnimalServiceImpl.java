package via.sdj3.slaughterhouse.restAPI.service;

import org.springframework.stereotype.Service;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.repository.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService{

    private AnimalRepository animalRepository;

    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public void create(Animal animal) throws Exception {
        animalRepository.create(animal);
    }

    @Override
    public Animal getById(int regId) throws Exception {
        return animalRepository.getById(regId);
    }

    //TODO: As previous todos: Add missing methods.
}
