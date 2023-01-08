package at.saap.antipatterntesting.cleancode.util;

import at.saap.antipatterntesting.cleancode.model.CalculationType;
import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.List;

public final class OrderCalculationUtils
{
    private OrderCalculationUtils() {}

    public static OrderCalculationResult calculateNetOrder(final Order order)
    {
        verifyOrder(order);
        calculateFromNet(order);

        return CalculationResultTransformer.transformOrder(order);
    }

    public static OrderCalculationResult calculateGrossOrder(final Order order)
    {
        verifyOrder(order);
        calculateFromGross(order);

        return CalculationResultTransformer.transformOrder(order);
    }

    private static void calculateFromNet(final Order order)
    {
        final BigDecimal vatRate = order.getItems().get(0).getPrice().getVatRate();
        for (Item item : order.getItems())
        {
            item.getPrice().setVatAmount(item.getPrice().getNetAmount().multiply(vatRate));
            item.getPrice().setGrossAmount(item.getPrice().getNetAmount().add(item.getPrice().getVatAmount()));
        }
    }

    private static void calculateFromGross(final Order order)
    {
        final BigDecimal calculationRate = order.getItems().get(0).getPrice().getVatRate().add(BigDecimal.ONE);
        for (Item item : order.getItems())
        {
            item.getPrice().setNetAmount(item.getPrice().getGrossAmount().divide(calculationRate, RoundingMode.HALF_UP));
            item.getPrice().setVatAmount(item.getPrice().getGrossAmount().subtract(item.getPrice().getNetAmount()));
        }
    }

    private static void verifyOrder(final Order order)
    {
        if (order.getItems().isEmpty() || !checkPrices(order.getCalculationType(), order.getItems()))
        {
            throw new InputMismatchException();
        }
        verifyVat(order.getItems());
    }

    private static void verifyVat(final List<Item> items)
    {
        final BigDecimal vatRate = items.get(0).getPrice().getVatRate();
        for (Item item : items)
        {
            if (item.getPrice().getVatRate() == null && vatRate.equals(item.getPrice().getVatRate()))
            {
                throw new InputMismatchException();
            }
        }
    }

    private static boolean checkPrices(final CalculationType calculationType, final List<Item> items)
    {
        if (CalculationType.NET.equals(calculationType))
        {
            return checkNetPrices(items);
        }
        return checkGrossPrices(items);
    }

    private static boolean checkNetPrices(final List<Item> items)
    {
        for (Item item : items)
        {
            if (item.getPrice().getNetAmount() == null)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean checkGrossPrices(final List<Item> items)
    {
        for (Item item : items)
        {
            if (item.getPrice().getGrossAmount() == null)
            {
                return false;
            }
        }
        return true;
    }

}
