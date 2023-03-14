package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeliveryAddress implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
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
