package com.apnatriangle.marketdataservice.entity;

import io.micrometer.core.annotation.Timed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, String> {
    @Timed(value = "findById")
    public Optional<MarketPrice> findById(String symbol);
}
