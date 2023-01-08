package at.saap.antipatterntesting.cleancode;

import at.saap.antipatterntesting.cleancode.model.CalculationType;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.cleancode.util.OrderCalculationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/order")
public class OrderServiceImpl implements OrderService
{
    @Override
    public OrderCalculationResult calculateOrder(final Order order)
    {
        if (CalculationType.NET.equals(order.getCalculationType()))
        {
            return OrderCalculationUtils.calculateNetOrder(order);
        }
        return OrderCalculationUtils.calculateGrossOrder(order);
    }
}
