package repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Item;

@ApplicationScoped
public class ItemRepository implements PanacheMongoRepository<Item> {
}
