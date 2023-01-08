package at.saap.antipatterntesting.antipattern;

import at.saap.antipatterntesting.util.SuperOrderTestUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

@SpringBootTest
@EnableAutoConfiguration
@Test
public class SuperOrderServiceTest
{
    private final SuperOrderService service = new SuperOrderService();

    @Test
    public void testNetCalculation()
    {
        SuperOrder order = SuperOrderTestUtils.createNetSuperOrder();
        order = service.calculateOrder(order);

        Assert.assertEquals(order.getGrossAmount().doubleValue(), 1200.);
        Assert.assertEquals(order.getVatAmount().doubleValue(), 200.);
    }

    @Test
    public void testGrossCalculation()
    {
        SuperOrder order = SuperOrderTestUtils.createGrossSuperOrder();
        order = service.calculateOrder(order);
        Assert.assertEquals(order.getNetAmount().doubleValue(), 1000.);
        Assert.assertEquals(order.getVatAmount().doubleValue(), 200.);
    }

}
