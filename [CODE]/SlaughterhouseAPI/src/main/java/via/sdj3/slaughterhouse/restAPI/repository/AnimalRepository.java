package via.sdj3.slaughterhouse.restAPI.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.slaughterhouse.restAPI.model.Animal;
import via.sdj3.slaughterhouse.restAPI.model.AnimalDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class AnimalRepository {

    private static final HashMap<Integer, Animal> animals = new HashMap<>();


    static {
        initDataSource();
    }

    private int id = animals.size();

    private static void initDataSource() {
        Animal a1 = new Animal(1, LocalDateTime.now(), 87.5, "Hedensted");
        Animal a2 = new Animal(2, LocalDateTime.now(), 187.5, "Hovensted");
        Animal a3 = new Animal(3, LocalDateTime.now(), 97.5, "Horsens");

        animals.put(a1.getRegId(), a1);
        animals.put(a2.getRegId(), a2);
        animals.put(a3.getRegId(), a3);

    }

    public Animal create(AnimalDTO dto) {
        id++;
        Animal toBeCreated = new Animal
                (id, LocalDateTime.now(), dto.getWeight(), dto.getOrigin());
        animals.put(toBeCreated.getRegId(), toBeCreated);
        return toBeCreated;
    }


    public Animal getById(int regId) throws Exception {

        return animals.get(regId);
    }

    public ArrayList<Animal> getAll() {
        ArrayList<Animal> animalsList = new ArrayList<>();
        animalsList.addAll(animals.values());
        return animalsList;
    }

    //TODO:Get all by date and get all by origin missing.
}
