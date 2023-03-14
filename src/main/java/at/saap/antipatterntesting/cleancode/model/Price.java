package at.saap.antipatterntesting.cleancode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Price implements Serializable
{
    @Serial
    private static final long serialVersionUID = 1L;
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
