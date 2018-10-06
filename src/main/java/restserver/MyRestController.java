package restserver;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MyRestController {
    private final static List<Person> persons = new CopyOnWriteArrayList<>();
    private final static AtomicLong idGenerator = new AtomicLong();

    @PostMapping("/create")
    public void create(@Valid @RequestBody NewPerson newPerson) {
        Person person = createPerson(newPerson);
        persons.add(person);
    }

    private Person createPerson(@RequestBody @Valid NewPerson newPerson) {
        Person person = new Person();
        person.setId(idGenerator.getAndIncrement());
        person.setName(newPerson.getName());
        return person;
    }

    @GetMapping("/read")
    public List<Person> read() {
        return persons;
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody Person updatedPerson) {
        Optional<Person> existingPerson = persons
                .stream()
                .filter(p -> p.getId() == updatedPerson.getId())
                .findFirst();
        updatePerson(updatedPerson, existingPerson.get());
    }

    @DeleteMapping("/delete/{id}")
    public void update(@PathVariable Long id) {
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
