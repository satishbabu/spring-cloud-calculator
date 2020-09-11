package com.apnatriangle.marketdataservice;

import com.apnatriangle.marketdataservice.entity.MarketPrice;
import com.apnatriangle.marketdataservice.entity.MarketPriceRepository;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockPriceService {
    @Autowired
    private MarketPriceRepository marketPriceRepository;

    @Timed(value = "getPriceById")
    public Optional<MarketPrice> getPriceById(String symbol) {
        return marketPriceRepository.findById(symbol);
    }
}
