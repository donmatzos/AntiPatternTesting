package at.saap.antipatterntesting.cleancode.util;

import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.Price;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;

import java.time.Instant;
import java.util.Date;

public final class CalculationResultTransformer
{
    private CalculationResultTransformer() {}

    public static OrderCalculationResult transformOrder(final Order order)
    {
        final OrderCalculationResult result = new OrderCalculationResult();
        fillBasicOrderInformation(result, order);
        calculateTotalOrderSum(result);

        return result;
    }

    private static void fillBasicOrderInformation(final OrderCalculationResult result, final Order order)
    {
        result.setCalculatedItems(order.getItems());
        result.setDeliveryAddress(order.getDeliveryAddress());
        result.setOrderDate(order.getOrderDate());
        result.setPaymentDate(order.getPaymentDate());
    }

    private static void calculateTotalOrderSum(final OrderCalculationResult result)
    {
        final Price totalPrice = new Price();
        for (Item item : result.getCalculatedItems())
        {
            totalPrice.setNetAmount(BigDecimalUtils.nullSafeAdd(totalPrice.getNetAmount(), item.getPrice().getNetAmount()));
            totalPrice.setVatAmount(BigDecimalUtils.nullSafeAdd(totalPrice.getVatAmount(), item.getPrice().getVatAmount()));
            totalPrice.setGrossAmount(BigDecimalUtils.nullSafeAdd(totalPrice.getGrossAmount(), item.getPrice().getGrossAmount()));
        }
        result.setOrderPrice(totalPrice);
        result.getOrderPrice().setVatRate(result.getCalculatedItems().get(0).getPrice().getVatRate());
        result.getOrderPrice().setCurrency(result.getCalculatedItems().get(0).getPrice().getCurrency());
        result.setCalculationDate(Date.from(Instant.now()));
    }

}
