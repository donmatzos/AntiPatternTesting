package at.saap.antipatterntesting.antipattern;

import at.saap.antipatterntesting.util.SuperOrderTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CalculateGrossOrderTest
{
    @Test
    public void testNetOrderCalculation()
    {
        SuperOrder order = SuperOrderTestUtils.createGrossSuperOrder();

        CalculateNetOrder.calculate(order);

        Assert.assertEquals(order.getNetAmount().doubleValue(), 1000.);
        Assert.assertEquals(order.getVatAmount().doubleValue(), 200.);
    }
}
