package resource;

import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Item;
import org.bson.types.ObjectId;
import repository.ItemRepository;
import service.ItemService;

import java.util.List;
import java.util.logging.Logger;

@Path("/items")
public class ItemResource {

    @Inject
    ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> get() {
        return itemService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Item get(@PathParam("id") ObjectId id) {
        return itemService.getById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Item post(Item item) {
        return itemService.create(item);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Item put(@PathParam("id") ObjectId id, Item item) {
        return itemService.update(id, item);
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") ObjectId id) {
        itemService.delete(id);
    }
}
