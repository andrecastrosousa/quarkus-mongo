package repository;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Supplier;

@ApplicationScoped
public class SupplierRepository implements PanacheMongoRepository<Supplier> {
}
