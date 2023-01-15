package at.saap.antipatterntesting.util;

import at.saap.antipatterntesting.antipattern.SuperItem;
import at.saap.antipatterntesting.antipattern.SuperOrder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public final class SuperOrderTestUtils
{
    public static SuperOrder createNetSuperOrder()
    {
        final SuperItem item = SuperItem.builder()
                .externalId("net item")
                .netAmount(BigDecimal.valueOf(1000.))
                .vatRate(BigDecimal.valueOf(.20))
                .currency(Currency.getInstance("EUR"))
                .build();
        final SuperOrder order = SuperOrder.builder()
                .calculationType("NET")
                .items(new ArrayList<>())
                .build();
        order.getItems().add(item);
        return order;
    }

    public static SuperOrder createGrossSuperOrder()
    {
        final SuperItem item = SuperItem.builder()
                .externalId("gross item")
                .grossAmount(BigDecimal.valueOf(1200.))
                .vatRate(BigDecimal.valueOf(.20))
                .currency(Currency.getInstance("EUR"))
                .build();
        final SuperOrder order = SuperOrder.builder()
                .calculationType("GROSS")
                .items(new ArrayList<>())
                .build();
        order.getItems().add(item);
        return order;
    }
}
