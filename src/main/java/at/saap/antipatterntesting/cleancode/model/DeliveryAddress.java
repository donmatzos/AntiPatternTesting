package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeliveryAddress
{
    private String name;
    private String street;
    private String country;
    private int zipCode;
}
