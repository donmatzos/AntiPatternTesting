package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Item
{
    @Getter
    @Setter
    private int amount;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Price price;
}
