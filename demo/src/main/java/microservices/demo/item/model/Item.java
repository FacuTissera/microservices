package microservices.demo.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String id;
    private String title;
    private String condition;
    private Double price;
    private String thumbnail;

}
