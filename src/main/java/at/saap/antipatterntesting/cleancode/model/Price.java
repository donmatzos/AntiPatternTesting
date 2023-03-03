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
@Getter
@Setter
public class Price
{
    private BigDecimal netAmount;
    private BigDecimal grossAmount;
    private BigDecimal vatAmount;
    private BigDecimal vatRate;
    private Currency currency;
}
