package at.htl.farm;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class AnimalResource {

    @Inject
    @RestClient
    AnimalService animalService;

    @GET
    @Path("/animal/count")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "Animals_called")
    @Timed(name = "timer", description = "How long it takes to perform this task", unit = MetricUnits.MILLISECONDS)
    public int getAnimals() {
        return animalService.getAnimal().size();
    }

    @GET
    @Path("/animal/avg/age")
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "Animal_avg_age_called")
    public double getAvgAge() {
        return animalService.getAnimal().stream().mapToDouble(a -> a.getAge()).average().getAsDouble();
    }
}