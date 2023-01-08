package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order
{
    @Getter
    @Setter
    private CalculationTypeEnum calculationType;

    @Getter
    @Setter
    private List<Item> items;

    @Getter
    @Setter
    private DeliveryAddress deliveryAddress;

    @Getter
    @Setter
    private Date orderDate;

    @Getter
    @Setter
    private Date paymentDate;
}
