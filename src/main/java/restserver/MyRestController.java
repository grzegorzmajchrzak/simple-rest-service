package restserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api")
public class MyRestController {
    private final static List<Person> persons = new CopyOnWriteArrayList<>();
    private final static AtomicLong idGenerator = new AtomicLong();

    private static final Logger LOGGER = LoggerFactory.getLogger(MyRestController.class);
    @PostMapping("/create")
    public void create(@Valid @RequestBody NewPerson newPerson) {
        Person person = createPerson(newPerson);
        persons.add(person);
    }

    private Person createPerson(@RequestBody @Valid NewPerson newPerson) {
        LOGGER.info("create {}", newPerson);
        Person person = new Person();
        person.setId(idGenerator.getAndIncrement());
        person.setName(newPerson.getName());
        return person;
    }

    @GetMapping("/read")
    public List<Person> read() {
        LOGGER.info("read");
        return persons;
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Person updatedPerson) {
        LOGGER.info("update {}", updatedPerson);
        Optional<Person> existingPerson = persons
                .stream()
                .filter(p -> p.getId() == updatedPerson.getId())
                .findFirst();
        updatePerson(updatedPerson, existingPerson.get());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        LOGGER.info("delete {}", id);
        Optional<Person> existingPerson = persons
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        persons.remove(existingPerson.get());

    }

    private void updatePerson(@RequestBody @Valid Person updatedPerson, Person existingPerson) {
        existingPerson.setName(updatedPerson.getName());
    }


}
