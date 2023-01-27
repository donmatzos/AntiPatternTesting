package at.saap.antipatterntesting.antipattern;

import at.saap.antipatterntesting.util.SuperOrderTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CalculateGrossOrderTest
{
    @Test
    public void testGrossOrderCalculation()
    {
        SuperOrder order = SuperOrderTestUtils.createGrossSuperOrder();

        CalculateGrossOrder.calculate(order);

        Assert.assertEquals(order.netAmount.doubleValue(), 1000.);
        Assert.assertEquals(order.vatAmount.doubleValue(), 200.);
    }
}
