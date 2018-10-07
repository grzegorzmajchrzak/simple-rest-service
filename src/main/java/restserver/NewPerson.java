package restserver;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class NewPerson {
    @Pattern(regexp="\\w+", message="name can contain only letters")
    private String name;
}
