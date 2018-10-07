package restserver;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.Min;

@Data
@ToString(callSuper = true)
public class Person extends NewPerson {

    @Min(0)
    private long id;
}
