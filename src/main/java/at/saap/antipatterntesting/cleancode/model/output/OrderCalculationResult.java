package at.saap.antipatterntesting.cleancode.model.output;

import at.saap.antipatterntesting.cleancode.model.DeliveryAddress;
import at.saap.antipatterntesting.cleancode.model.Item;
import at.saap.antipatterntesting.cleancode.model.Price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCalculationResult
{
    private Price orderPrice;
    private List<Item> calculatedItems;
    private DeliveryAddress deliveryAddress;
    private Date orderDate;
    private Date paymentDate;
    private Date calculationDate;
}
