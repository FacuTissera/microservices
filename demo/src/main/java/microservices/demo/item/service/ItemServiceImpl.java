package microservices.demo.item.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import microservices.demo.item.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

    private String URI = "https://api.mercadolibre.com/sites/MLA/search?q=";

    @Override
    public List<Item> getAllItemsWithName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        List<Item> items = new ArrayList<>();
        ArrayNode array;

        try {
            String response = restTemplate.getForObject(URI + name, String.class);
            JsonNode rootNode = mapper.readTree(response);
            array = (ArrayNode) rootNode.get("results");
            for (Object object : array) {
                ObjectNode json = (ObjectNode) object;
                items.add(new Item(
                        json.get("id").asText(),
                        json.get("title").asText(),
                        json.get("condition").asText(),
                        json.get("price").asDouble(),
                        json.get("thumbnail").asText()));
            }
        } catch (Exception e) {
            throw new InternalError("error fetching data from meli api" + e.getMessage());
        }
        return items;
    }
}
