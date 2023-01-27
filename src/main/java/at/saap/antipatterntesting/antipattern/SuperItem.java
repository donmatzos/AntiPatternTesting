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

    public BigDecimal netAmount = BigDecimal.ZERO;

    public BigDecimal grossAmount = BigDecimal.ZERO;

    public BigDecimal vatAmount = BigDecimal.ZERO;

    public BigDecimal vatRate = BigDecimal.ZERO;

    public Currency currency;
}
