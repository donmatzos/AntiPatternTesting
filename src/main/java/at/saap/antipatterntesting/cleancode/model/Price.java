package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    private BigDecimal vatRate;

    @Getter
    @Setter
    private Currency currency;
}
