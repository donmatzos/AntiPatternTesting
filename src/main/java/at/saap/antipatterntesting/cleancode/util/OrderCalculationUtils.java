package at.saap.antipatterntesting.cleancode.util;

import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public final class OrderCalculationUtils
{
    private OrderCalculationUtils() {}

    public static OrderCalculationResult calculateNetOrder(final Order order)
    {
        calculateItemsFromNet(order.getItems());

        return CalculationResultTransformer.transformOrder(order);
    }

    public static OrderCalculationResult calculateGrossOrder(final Order order)
    {
        calculateItemsFromGross(order.getItems());

        return CalculationResultTransformer.transformOrder(order);
    }

    private static void calculateItemsFromNet(final List<Item> items)
    {
        final BigDecimal vatRate = items.get(0).getPrice().getVatRate();
        for (Item item : items)
        {
            item.getPrice().setVatAmount(item.getPrice().getNetAmount().multiply(vatRate));
            item.getPrice().setGrossAmount(item.getPrice().getNetAmount().add(item.getPrice().getVatAmount()));
        }
    }

    private static void calculateItemsFromGross(final List<Item> items)
    {
        final BigDecimal calculationRate = items.get(0).getPrice().getVatRate().add(BigDecimal.ONE);
        for (Item item : items)
        {
            item.getPrice().setNetAmount(item.getPrice().getGrossAmount().divide(calculationRate, RoundingMode.HALF_UP));
            item.getPrice().setVatAmount(item.getPrice().getGrossAmount().subtract(item.getPrice().getNetAmount()));
        }
    }
}
