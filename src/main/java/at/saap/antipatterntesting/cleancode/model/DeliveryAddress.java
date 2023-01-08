package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAddress
{
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String street;
    @Getter
    @Setter
    private String country;
    @Getter
    @Setter
    private int zipCode;
}
