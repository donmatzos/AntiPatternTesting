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
@Getter
@Setter
public class Order
{
    private CalculationTypeEnum calculationType;
    private List<Item> items;
    private DeliveryAddress deliveryAddress;
    private Date orderDate;
    private Date paymentDate;
}
