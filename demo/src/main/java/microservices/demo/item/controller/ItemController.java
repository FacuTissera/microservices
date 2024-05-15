package microservices.demo.item.controller;

import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import microservices.demo.item.model.Item;
import microservices.demo.item.service.ItemService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item")
    public List<Item> getAllItemsWithName(@RequestParam String itemName) {
        return itemService.getAllItemsWithName(itemName);
    }

}
