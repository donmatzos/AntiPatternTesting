package at.saap.antipatterntesting.cleancode;

import at.saap.antipatterntesting.cleancode.model.CalculationTypeEnum;
import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.Price;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.util.OrderTestUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.InputMismatchException;

@SpringBootTest
@EnableAutoConfiguration
@Test
public class OrderServiceTest extends AbstractTestNGSpringContextTests
{
    //this -> INTEGRATION
    private final OrderServiceImpl orderService = new OrderServiceImpl();

    @Test
    public void testNetCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationTypeEnum.NET, BigDecimal.valueOf(2000.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = orderService.calculateOrder(order);

        Assert.assertEquals(result.getOrderPrice().getGrossAmount().doubleValue(), 2400.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }

    @Test
    public void testGrossCalculation()
    {
        final Order order = OrderTestUtils.createOrder(CalculationTypeEnum.GROSS, BigDecimal.valueOf(2400.), BigDecimal.valueOf(.20));

        final OrderCalculationResult result = orderService.calculateOrder(order);

        Assert.assertEquals(result.getOrderPrice().getNetAmount().doubleValue(), 2000.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 400.);
        Assert.assertEquals(result.getOrderPrice().getCurrency(), Currency.getInstance("EUR"));
    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testNullVatInput()
    {
        final Order order = new Order();
        order.setCalculationType(CalculationTypeEnum.NET);
        order.setItems(new ArrayList<>());

        orderService.calculateOrder(order);
    }

    @Test(expectedExceptions = InputMismatchException.class)
    public void testWrongVatInput()
    {
        final Order order = new Order();
        order.setCalculationType(CalculationTypeEnum.NET);
        order.setItems(new ArrayList<>());
        final Price initialPrice = Price.builder().vatRate(BigDecimal.valueOf(0.2)).build();
        order.getItems().add(Item.builder().price(initialPrice).build());
        final Price wrongPrice = Price.builder().vatRate(BigDecimal.valueOf(0.21)).build();
        order.getItems().add(Item.builder().price(wrongPrice).build());

        orderService.calculateOrder(order);
    }

}
