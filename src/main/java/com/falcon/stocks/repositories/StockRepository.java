package com.falcon.stocks.repositories;

import com.falcon.stocks.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
