package at.htl.farm;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Liveness
@ApplicationScoped
public class MyHealthCheck implements HealthCheck {

    @Inject
    @RestClient
    AnimalService animalService;

    @PostConstruct
    public void initClient() {
    }

    @Override
    public HealthCheckResponse call(){
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("GCA Server Status");
        try{
            animalService.getAnimal();
            responseBuilder.up();
        } catch (Exception e){
            responseBuilder.down();
        }
        return responseBuilder.build();
    }
}