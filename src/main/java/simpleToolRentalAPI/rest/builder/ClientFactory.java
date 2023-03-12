package simpleToolRentalAPI.rest.builder;

import simpleToolRentalAPI.rest.model.Client;

import static simpleToolRentalAPI.utils.GeneratorUtils.generateEmail;
import static simpleToolRentalAPI.utils.GeneratorUtils.generateName;

public class ClientFactory {
    public static Client newDefaultClient(){
        return Client.builder()
                .clientName(generateName())
                .clientEmail(generateEmail())
                .build();
    }
}
