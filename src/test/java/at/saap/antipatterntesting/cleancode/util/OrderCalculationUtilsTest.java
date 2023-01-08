package at.saap.antipatterntesting.cleancode.util;

import at.saap.antipatterntesting.cleancode.model.CalculationTypeEnum;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.util.OrderTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Currency;

@Test
public class OrderCalculationUtilsTest
{
    //this -> UNIT
    @Test
    public void testNetCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationTypeEnum.NET, BigDecimal.valueOf(2000.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = OrderCalculationUtils.calculateNetOrder(order);

        Assert.assertEquals(result.getOrderPrice().getGrossAmount().doubleValue(), 2400.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }

    @Test
    public void testGrossCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationTypeEnum.GROSS, BigDecimal.valueOf(2400.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = OrderCalculationUtils.calculateGrossOrder(order);

        Assert.assertEquals(result.getOrderPrice().getNetAmount().doubleValue(), 2000.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }
}
