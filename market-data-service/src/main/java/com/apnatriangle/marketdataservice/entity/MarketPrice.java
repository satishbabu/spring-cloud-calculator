package com.apnatriangle.marketdataservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class MarketPrice {
    @Id
    String symbol;

    BigDecimal price;

    protected MarketPrice() {

    }

    public MarketPrice(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MarketPrice{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
