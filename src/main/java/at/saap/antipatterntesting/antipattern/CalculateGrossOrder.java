package at.saap.antipatterntesting.antipattern;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.Date;

public class CalculateGrossOrder
{
    public static void calculate(SuperOrder order)
    {
        final BigDecimal vatRate = order.getItems().get(0).getVatRate();
        order.setVatRate(vatRate);
        final BigDecimal calculationRate = vatRate.add(BigDecimal.ONE);
        order.setNetAmount(BigDecimal.ZERO);
        order.setVatAmount(BigDecimal.ZERO);
        order.setGrossAmount(BigDecimal.ZERO);
        for (SuperItem item : order.getItems())
        {
            item.setNetAmount(item.getGrossAmount().divide(calculationRate, RoundingMode.HALF_UP));
            item.setVatAmount(item.getGrossAmount().subtract(item.getNetAmount()));
            order.setNetAmount(order.getNetAmount().add(item.getNetAmount()));
            order.setVatAmount(order.getVatAmount().add(item.getVatAmount()));
            order.setCurrency(item.getCurrency());
        }
        order.setCalculationDate(Date.from(Instant.now()));
    }
}
