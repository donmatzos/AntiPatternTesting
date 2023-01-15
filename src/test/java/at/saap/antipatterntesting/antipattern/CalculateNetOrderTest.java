package at.saap.antipatterntesting.antipattern;

import at.saap.antipatterntesting.util.SuperOrderTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CalculateNetOrderTest
{
    @Test
    public void testNetOrderCalculation()
    {
        SuperOrder order = SuperOrderTestUtils.createNetSuperOrder();

        CalculateNetOrder.calculate(order);

        Assert.assertEquals(order.getGrossAmount().doubleValue(), 1200.);
        Assert.assertEquals(order.getVatAmount().doubleValue(), 200.);
    }
}
