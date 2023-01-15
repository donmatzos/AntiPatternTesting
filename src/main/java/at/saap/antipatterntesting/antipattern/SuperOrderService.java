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
            if (order.getItems().isEmpty())
            {
                return null;
            }
            if (order.getCalculationType().equals("NET")
                && order.getItems().stream().anyMatch(item -> item.getNetAmount() == null))
            {
                return null;
            }
            else if (order.getCalculationType().equals("GROSS")
                    && order.getItems().stream().anyMatch(item -> item.getGrossAmount() == null))
            {
                return null;
            }
            final BigDecimal vatRate = order.getItems().get(0).getVatRate();
            for (SuperItem item : order.getItems())
            {
                if (item.getVatRate() == null && vatRate.equals(item.getVatRate()))
                {
                    return null;
                }
            }
            if (order.getCalculationType().equals("NET"))
            {
                CalculateNetOrder.calculate(order);
            }
            else if (order.getCalculationType().equals("GROSS"))
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
