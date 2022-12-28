package at.saap.antipatterntesting.cleancode.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Order
{
    @Getter
    @Setter
    private Item item;

    @Getter
    @Setter
    private Date orderDate;

    @Getter
    @Setter
    private Date paymentDate;

    @Getter
    @Setter
    private DeliveryAddress deliveryAddress;
}
