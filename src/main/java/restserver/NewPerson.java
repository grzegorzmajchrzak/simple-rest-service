package restserver;

import javax.validation.constraints.Pattern;

public class NewPerson {

    @Pattern(regexp="\\w+", message="name can contain only letters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
