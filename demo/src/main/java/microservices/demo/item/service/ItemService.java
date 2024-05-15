package microservices.demo.item.service;

import java.util.List;

import microservices.demo.item.model.Item;

public interface ItemService {

    public List<Item> getAllItemsWithName(String name);

}
