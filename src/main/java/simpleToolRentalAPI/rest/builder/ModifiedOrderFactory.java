package simpleToolRentalAPI.rest.builder;

import simpleToolRentalAPI.rest.model.ModifiedOrder;
import simpleToolRentalAPI.utils.GeneratorUtils;

public class ModifiedOrderFactory {
    public static ModifiedOrder modifiedOrder() {
        return ModifiedOrder.builder()
                .customerName(GeneratorUtils.generateName())
                .comment(GeneratorUtils.generateComment())
                .build();
    }
}
