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
public class OrderCalculationResult
{
    @Getter
    @Setter
    private Price orderPrice;

    @Getter
    @Setter
    private List<Item> calculatedItems;

    @Getter
    @Setter
    private DeliveryAddress deliveryAddress;

    @Getter
    @Setter
    private Date orderDate;

    @Getter
    @Setter
    private Date paymentDate;

    @Getter
    @Setter
    private Date calculationDate;
}
