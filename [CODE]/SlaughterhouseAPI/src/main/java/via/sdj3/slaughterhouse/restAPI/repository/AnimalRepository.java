package via.sdj3.slaughterhouse.restAPI.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.slaughterhouse.restAPI.model.Animal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;

@Repository
public class AnimalRepository {

    private static final HashMap<Integer, Animal> animals = new HashMap<>();

    static {
        initDataSource();
    }

    private static void initDataSource() {
        Animal a1 = new Animal(1, LocalDateTime.now(), 87.5, "Hedensted");
        Animal a2 = new Animal(2, LocalDateTime.now(), 187.5, "Hovensted");
        Animal a3 = new Animal(3, LocalDateTime.now(), 97.5, "Horsens");

        animals.put(a1.getRegId(), a1);
        animals.put(a2.getRegId(), a2);
        animals.put(a3.getRegId(), a3);

    }

    public void create(Animal animal) throws Exception {
        if(animal!=null)
        {
            animals.put(animal.getRegId(), animal);
            return;
        }
        throw new Exception("Animal cannot be null.");
    }

    public Animal getById(int regId) throws Exception {
        if(regId>=1)
        {
            return animals.get(regId);
        }
        throw new Exception("ID has to be a positive integer.");
    }

    //TODO:Get all by date and get all by origin missing.
}
