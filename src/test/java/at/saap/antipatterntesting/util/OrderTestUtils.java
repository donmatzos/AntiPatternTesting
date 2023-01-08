package at.saap.antipatterntesting.util;

import at.saap.antipatterntesting.cleancode.model.CalculationType;
import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.Price;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;

public final class OrderTestUtils
{
    private OrderTestUtils() {}

    public static Order createOrder(final CalculationType calculationType, final BigDecimal priceAmount, final BigDecimal vatRate)
    {
        final Order order = Order.builder()
                .calculationType(calculationType)
                .items(new ArrayList<>())
                .orderDate(Date.from(Instant.now()))
                .paymentDate(Date.from(Instant.now()))
                .build();
        addItemToOrder(order, priceAmount, vatRate);

        return order;
    }

    private static void addItemToOrder(final Order order, final BigDecimal priceAmount, final BigDecimal vatRate)
    {
        if (CalculationType.NET.equals(order.getCalculationType()))
        {
            final Item item = Item.builder()
                    .name("item 1")
                    .price(createNetPrice(priceAmount, vatRate))
                    .build();
            order.getItems().add(item);
        }
        else if (CalculationType.GROSS.equals(order.getCalculationType()))
        {
            final Item item = Item.builder()
                    .name("item 1")
                    .price(createGrossPrice(priceAmount, vatRate))
                    .build();
            order.getItems().add(item);
        }
    }

    private static Price createNetPrice(final BigDecimal netAmount, final BigDecimal vatRate)
    {
        return Price.builder()
                .netAmount(netAmount)
                .vatRate(vatRate)
                .currency(Currency.getInstance("EUR"))
                .build();
    }

    private static Price createGrossPrice(BigDecimal grossAmount, BigDecimal vatRate)
    {
        return Price.builder()
                .grossAmount(grossAmount)
                .vatRate(vatRate)
                .currency(Currency.getInstance("EUR"))
                .build();
    }

}
