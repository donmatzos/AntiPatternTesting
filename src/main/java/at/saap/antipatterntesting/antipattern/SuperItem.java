package at.saap.antipatterntesting.antipattern;

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
public class SuperItem
{
    @Getter
    @Setter
    private String externalId;

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
