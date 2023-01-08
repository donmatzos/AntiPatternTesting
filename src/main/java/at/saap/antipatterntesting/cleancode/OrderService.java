package at.saap.antipatterntesting.cleancode;

import at.saap.antipatterntesting.cleancode.model.Order;
import at.saap.antipatterntesting.cleancode.model.output.OrderCalculationResult;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface OrderService
{
    @GetMapping("/calculate-order")
    OrderCalculationResult calculateOrder(@RequestBody final Order order);
}