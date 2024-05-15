package microservices.demo.country.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import microservices.demo.country.model.Country;
import microservices.demo.country.service.CountryService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryService.getAllContries();
    }

    @GetMapping("/countries/{name}")
    public List<Country> getAllCountriesWithName(@PathVariable("name") String name) {
        return countryService.getAllContriesWithName(name);
    }

}
