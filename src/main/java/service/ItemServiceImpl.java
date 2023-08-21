package service;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import model.Item;
import org.bson.types.ObjectId;
import repository.ItemRepository;

import java.util.List;

@ApplicationScoped
public class ItemServiceImpl implements ItemService {

    @Inject
    ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return itemRepository.listAll();
    }

    @Override
    public Item getById(ObjectId id) {
        Item item = itemRepository.findById(id);
        if(item == null) {
            throw new WebApplicationException("Item not found", 404);
        }
        return item;
    }

    @Override
    public Item create(Item item) {
        itemRepository.persist(item);
        return item;
    }

    @Override
    public Item update(ObjectId id, Item item) {
        Item itemFound = itemRepository.findById(id);
        if(itemFound == null) {
            throw new WebApplicationException("Item not found", 404);
        }
        itemFound.setPrice(item.getPrice());
        itemFound.setDescription(item.getDescription());
        itemFound.setCategory(item.getCategory());

        return item;
    }

    @Override
    public void delete(ObjectId id) {
        Item item = itemRepository.findById(id);
        if(item == null) {
            throw new WebApplicationException("Item not found", 404);
        }
        itemRepository.delete(item);
    }
}
