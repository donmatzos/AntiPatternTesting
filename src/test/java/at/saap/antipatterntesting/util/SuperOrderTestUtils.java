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
        final SuperItem item = new SuperItem();
        item.externalId = "net item";
        item.netAmount = BigDecimal.valueOf(1000.);
        item.vatRate = BigDecimal.valueOf(.20);
        item.currency = Currency.getInstance("EUR");
        final SuperOrder order = new SuperOrder();
        order.calculationType = "NET";
        order.items = new ArrayList<>();
        order.items.add(item);
        return order;
    }

    public static SuperOrder createGrossSuperOrder()
    {
        final SuperItem item = new SuperItem();
        item.externalId = "gross item";
        item.grossAmount = BigDecimal.valueOf(1200.);
        item.vatRate = BigDecimal.valueOf(.20);
        item.currency = Currency.getInstance("EUR");
        final SuperOrder order = new SuperOrder();
        order.calculationType = "GROSS";
        order.items = new ArrayList<>();
        order.items.add(item);
        return order;
    }
}
