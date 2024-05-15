package microservices.demo.country.service;

import java.util.List;

import microservices.demo.country.model.Country;

public interface CountryService {

    public List<Country> getAllContries();

    public List<Country> getAllContriesWithName(String name);
}
