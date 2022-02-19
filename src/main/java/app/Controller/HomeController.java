package app.Controller;

import app.dto.Animal;
import app.dto.Person;
import app.entities.AnimalEntity;
import app.entities.PersonEntity;
import app.mapper.AnimalMapper;
import app.mapper.PersonMapper;
import app.repositories.AnimalRepository;
import app.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class HomeController {
    //private static List<Animal> list = new ArrayList<>();
//    private  final AnimalRepository animalRepository;
//    private final AnimalMapper animalMapper;
//
//    @Autowired
//    public HomeController(AnimalRepository animalRepository,
//                          AnimalMapper animalMapper) {
//        this.animalRepository = animalRepository;
//        this.animalMapper = animalMapper;
//    }
//
//    @GetMapping("/")
//    public List<AnimalEntity> index() {
//        return animalRepository.findAll();
//    };
//
//    @PostMapping("/create")
//    public String add(Animal animal) {
//        try {
//            AnimalEntity animalEntity = animalMapper.AnimalToAnimalEntity(animal);
//            animalRepository.save(animalEntity);
//            return "Animal has added";
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//    }
//
//    @DeleteMapping("/del")
//    public String del(int id) {
//        try {
//            animalRepository.deleteById(id);
//            return "Animal has del";
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//    }
//
//    @PutMapping("/update")
//    public String update(int id, String newName) {
//        try {
//            animalRepository.getById(id).setName(newName);
//            return "Animal has updated";
//        } catch (Exception ex) {
//            return ex.getMessage();
//        }
//    }

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @GetMapping("/")
    public List<PersonEntity> index() {
        return personRepository.findAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Person person) {
        try {
            if(person.getImage() != "") {
                String [] charArray = person.getImage().split(",");
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] bytes = new byte[0];
                bytes = decoder.decode(charArray[1]);
                String imgName = generateNameImg()+".jpg";
                String directory= "uploaded/"+imgName;
                new FileOutputStream(directory).write(bytes);
                PersonEntity personEntity = personMapper.PersonToPersonEntity(person);
                personEntity.setImage(imgName);
                personRepository.save(personEntity);
            } else {
                PersonEntity personEntity = personMapper.PersonToPersonEntity(person);
                personEntity.setImage("");
                personRepository.save(personEntity);
            }
        return "Person has successfully added";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    @GetMapping("/get")
    public PersonEntity get(String name) {
        if(name != "") {
            return personRepository.findByName(name);
        } else {
            return null;
        }
    }

    public String generateNameImg() {
        String generatedString = RandomStringUtils.randomAlphabetic(10);

        return generatedString;
    }
}
