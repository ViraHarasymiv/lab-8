package simpleToolRentalAPI.rest.builder;

import simpleToolRentalAPI.rest.model.Order;
import simpleToolRentalAPI.utils.GeneratorUtils;

public class UpdatedOrderBuilder {
    public static Order modifiedOrder() {
        return Order.builder()
                .customerName(GeneratorUtils.generateName())
                .comment(GeneratorUtils.generateComment())
                .build();
    }
}
