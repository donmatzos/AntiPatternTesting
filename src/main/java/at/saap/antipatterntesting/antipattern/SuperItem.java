package at.saap.antipatterntesting.antipattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@AllArgsConstructor
@NoArgsConstructor
public class SuperItem
{
    public String externalId;

    public BigDecimal netAmount;

    public BigDecimal grossAmount;

    public BigDecimal vatAmount;

    public BigDecimal vatRate;

    public Currency currency;
}
