package at.saap.antipatterntesting.antipattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SuperOrder
{
    public BigDecimal netAmount = BigDecimal.ZERO;
    public BigDecimal grossAmount = BigDecimal.ZERO;
    public BigDecimal vatAmount = BigDecimal.ZERO;
    public BigDecimal vatRate = BigDecimal.ZERO;
    public Currency currency;
    public String calculationType;
    public List<SuperItem> items;
    public String deliveryName;
    public String street;
    public String country;
    public int zipCode;
    public Date orderDate;
    public Date paymentDate;
    public Date calculationDate;
}
