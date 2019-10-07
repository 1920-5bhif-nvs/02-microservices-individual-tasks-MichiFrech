package at.htl.farm;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/animal")
@RegisterRestClient
public interface AnimalService {

    @GET
    @Produces("application/json")
    List<Animal> getAnimal();
}