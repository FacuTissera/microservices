package microservices.demo.country.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    private String name;
    private String region;
    private Long population;
    private String flag;

}
