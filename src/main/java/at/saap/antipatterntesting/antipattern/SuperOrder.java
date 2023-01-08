package at.saap.antipatterntesting.antipattern;

import at.saap.antipatterntesting.cleancode.model.CalculationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SuperOrder
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

    @Getter
    @Setter
    private CalculationTypeEnum calculationType;

    @Getter
    @Setter
    private List<SuperItem> items;

    @Getter
    @Setter
    private String deliveryName;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String country;

    @Getter
    @Setter
    private int zipCode;

    @Getter
    @Setter
    private Date orderDate;

    @Getter
    @Setter
    private Date paymentDate;

    @Getter
    @Setter
    private Date calculationDate;
}
