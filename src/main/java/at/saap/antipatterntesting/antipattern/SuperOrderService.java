package at.saap.antipatterntesting.antipattern;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * "This class is really the heart of our architecture"
 */
@ResponseBody
@Service("superOrderService")
@RequestMapping("/super-order")
public class SuperOrderService
{
    @PostMapping("/calculate-super-order")
    public SuperOrder calculateOrder(@RequestBody SuperOrder order)
    {
        //"VERIFICATION"
        if (order != null)
        {
            if (order.items.isEmpty())
            {
                return null;
            }
            if (order.calculationType.equals("NET")
                && order.items.stream().anyMatch(item -> item.netAmount == null))
            {
                return null;
            }
            else if (order.calculationType.equals("GROSS")
                    && order.items.stream().anyMatch(item -> item.grossAmount == null))
            {
                return null;
            }
            final BigDecimal vatRate = order.items.get(0).vatRate;
            for (SuperItem item : order.items)
            {
                if (!vatRate.equals(item.vatRate))
                {
                    return null;
                }
            }
            if (order.calculationType.equals("NET"))
            {
                CalculateNetOrder.calculate(order);
            }
            else if (order.calculationType.equals("GROSS"))
            {
                CalculateGrossOrder.calculate(order);
            }
            else
            {
                return null;
            }
        }
        return order;
    }
}
