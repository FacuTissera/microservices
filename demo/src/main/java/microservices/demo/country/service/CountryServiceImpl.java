package microservices.demo.country.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import microservices.demo.country.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

    private String URI = "https://restcountries.com/v3.1/all";

    @Override
    public List<Country> getAllContries() {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(URI, String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<Country> countries = new ArrayList<>();
        ArrayNode array;
        try {
            array = (ArrayNode) mapper.readTree(response);
            for (Object object : array) {
                ObjectNode json = (ObjectNode) object;
                countries.add(new Country(
                        json.get("name").get("official").asText(),
                        json.get("region").asText(),
                        (Long) json.get("population").asLong(),
                        json.get("flags").get("png").asText()));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public List<Country> getAllContriesWithName(String name) {
        return getAllContries().stream().filter(c -> c.getName().contains(name)).collect(Collectors.toList());
    }

}
