package at.saap.antipatterntesting.cleancode.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

public class Price
{
    @Getter
    @Setter
    private BigDecimal netAmount;

    @Getter
    @Setter
    private BigDecimal grossAmount;

    @Getter
    @Setter
    private BigDecimal vatAmount;

    @Getter
    @Setter
    private int vatRate;

    @Getter
    @Setter
    private Currency currency;
}
