package service;

import model.Item;
import org.bson.types.ObjectId;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item getById(ObjectId id);
    Item create(Item item);
    Item update(ObjectId id, Item item);
    void delete(ObjectId id);
}
