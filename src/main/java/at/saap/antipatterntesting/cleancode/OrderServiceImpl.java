package at.saap.antipatterntesting.cleancode;

import at.saap.antipatterntesting.cleancode.model.CalculationType;
import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import at.saap.antipatterntesting.cleancode.util.OrderCalculationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component("orderService")
@RequestMapping("/order")
//this -> INTEGRATION
public class OrderServiceImpl implements OrderService
{
    @Override
    public OrderCalculationResult calculateOrder(@RequestBody final Order order)
    {
        if (CalculationType.NET.equals(order.getCalculationType()))
        {
            return OrderCalculationUtils.calculateNetOrder(order);
        }
        return OrderCalculationUtils.calculateGrossOrder(order);
    }
}
