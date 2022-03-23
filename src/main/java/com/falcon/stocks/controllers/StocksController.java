package com.falcon.stocks.controllers;

import com.falcon.stocks.models.Stock;
import com.falcon.stocks.repositories.StockRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController(value = "/products")
@RequestMapping("/stocks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StocksController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<Stock> list() {
        return stockRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Stock get(@PathVariable Long id) {
        return stockRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stock create(@RequestBody final Stock stock) {
        return stockRepository.saveAndFlush(stock);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        stockRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Stock update(@PathVariable Long id, @RequestBody Stock stock) {
        Stock existingStock = stockRepository.getById(id);
        BeanUtils.copyProperties(stock, existingStock, "id");
        return stockRepository.saveAndFlush(existingStock);
    }
}
