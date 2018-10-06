package restserver;

import javax.validation.constraints.Min;

public class Person extends NewPerson {

    @Min(0)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
