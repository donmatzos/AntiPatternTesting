package at.saap.antipatterntesting.cleancode;

import at.saap.antipatterntesting.cleancode.model.CalculationType;
import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.cleancode.util.OrderCalculationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.List;

@Component("orderService")
@RequestMapping("/order")
public class OrderServiceImpl implements OrderService
{
    @Override
    public OrderCalculationResult calculateOrder(@RequestBody final Order order)
    {
        verifyOrder(order);
        return CalculationType.NET.equals(order.getCalculationType())
                ? OrderCalculationUtils.calculateNetOrder(order)
                : OrderCalculationUtils.calculateGrossOrder(order);
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
        return CalculationType.NET.equals(calculationType) ? checkNetPrices(items) : checkGrossPrices(items);
    }

    private static boolean checkNetPrices(final List<Item> items)
    {
        return items.stream().anyMatch(item -> item.getPrice().getNetAmount() == null);
    }

    private static boolean checkGrossPrices(final List<Item> items)
    {
        return items.stream().anyMatch(item -> item.getPrice().getGrossAmount() == null);
    }

}
