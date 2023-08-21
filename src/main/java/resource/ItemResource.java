package resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Item;
import service.ItemService;

import java.util.List;

@Path("/items")
public class ItemResource {

    @Inject
    ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> get() {
        return itemService.getAll();
    }
}
