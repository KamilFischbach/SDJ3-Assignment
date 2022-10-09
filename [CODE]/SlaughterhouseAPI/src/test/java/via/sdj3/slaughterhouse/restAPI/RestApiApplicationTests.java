package via.sdj3.slaughterhouse.restAPI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import via.sdj3.slaughterhouse.restAPI.controller.AnimalApiController;
import via.sdj3.slaughterhouse.restAPI.model.AnimalDTO;
import via.sdj3.slaughterhouse.restAPI.model.DateDTO;
import via.sdj3.slaughterhouse.restAPI.repository.AnimalRepository;
import via.sdj3.slaughterhouse.restAPI.service.AnimalServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestApiApplicationTests {

    AnimalApiController controller;
    @BeforeEach
    public void initEach() {
        controller =
                new AnimalApiController(new AnimalServiceImpl(new AnimalRepository()));
    }

    @Test
    void contextLoads() {

    }

    @Test
    void createZ()
    {
        assertThrows(Exception.class,() -> controller.create(null));
    }
    @Test
    void createO()
    {
        assertNotNull(controller.create(new AnimalDTO("Horsens", 87.5)));
    }

    @Test
    void getByIdZ()
    {
        assertThrows(Exception.class, () -> controller.getById(0));
    }
    @Test
    void getByIdO()
    {
        assertNotNull(controller.getById(1));
    }

    @Test
    void getByDateZ()
    {
        assertThrows(Exception.class, ()-> controller.getByDate(new DateDTO(0,0,0)));
    }

    @Test
    void getByDateO()
    {
        assertNotNull(controller.getByDate(new DateDTO(9,10,2022)));
    }

    @Test
    void getByOriginZ()
    {
       assertThrows(Exception.class, ()-> controller.getByOrigin(null));
    }

    @Test
    void getByOriginO()
    {
        assertNotNull(controller.getByOrigin("Horsens"));
    }
}
