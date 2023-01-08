package at.saap.antipatterntesting.antipattern;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class CalculateNetOrder
{
    public static void calculate(SuperOrder order)
    {
        final BigDecimal vatRate = order.getItems().get(0).getVatRate();
        order.setVatRate(vatRate);
        order.setNetAmount(BigDecimal.ZERO);
        order.setVatAmount(BigDecimal.ZERO);
        order.setGrossAmount(BigDecimal.ZERO);
        for (SuperItem item : order.getItems())
        {
            item.setVatAmount(item.getNetAmount().multiply(vatRate));
            item.setGrossAmount(item.getNetAmount().add(item.getVatAmount()));
            order.setNetAmount(order.getNetAmount().add(item.getNetAmount()));
            order.setVatAmount(order.getVatAmount().add(item.getVatAmount()));
            order.setGrossAmount(order.getGrossAmount().add(item.getGrossAmount()));
            order.setCurrency(item.getCurrency());
        }
        order.setCalculationDate(Date.from(Instant.now()));
    }
}
