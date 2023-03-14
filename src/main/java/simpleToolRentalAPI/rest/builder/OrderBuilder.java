package simpleToolRentalAPI.rest.builder;

import simpleToolRentalAPI.rest.model.Order;
import simpleToolRentalAPI.utils.GeneratorUtils;

public class OrderBuilder {
    public static Order newDefaultOrder(){
        return Order.builder()
                .toolId(4643)
                .customerName(GeneratorUtils.generateName())
                .comment(GeneratorUtils.generateComment())
                .build();
    }
}
