package at.saap.antipatterntesting.cleancode.util;

import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.util.OrderTestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CalculationResultTransformerTest
{
    //this -> UNIT
    @Test
    public void testCalculationResulTransformer()
    {
        final Order order = OrderTestUtils.createDemoTestOrder();

        final OrderCalculationResult result = CalculationResultTransformer.transformOrder(order);

        Assert.assertNotNull(result.getOrderPrice());
        Assert.assertNotNull(result.getCalculatedItems());
        Assert.assertNotNull(result.getDeliveryAddress());
        Assert.assertNotNull(result.getOrderDate());
        Assert.assertNotNull(result.getPaymentDate());
        Assert.assertNotNull(result.getCalculationDate());
        Assert.assertEquals(result.getOrderPrice().getNetAmount().doubleValue(), 5000.);
        Assert.assertEquals(result.getOrderPrice().getVatAmount().doubleValue(), 1000.);
        Assert.assertEquals(result.getOrderPrice().getGrossAmount().doubleValue(), 6000.);
    }
}
