package at.saap.antipatterntesting.cleancode.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

public class Order
{
    @Getter
    @Setter
    private CalculationType calculationType;

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
