package com.stocksapi.Controller;

import com.stocksapi.DTO.StockShareDTO;
import com.stocksapi.Service.StockShareService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shares")
public class StockShareController {

    private final StockShareService stockShareService;

    @PutMapping( value = "/purchases", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockShareDTO> purchaseStock(@RequestBody StockShareDTO stockShare) {
        StockShareDTO savedStockShare = stockShareService.purchaseStock(stockShare);
        return new ResponseEntity<>(savedStockShare, HttpStatus.CREATED);
    }

    @PutMapping(value = "/sales", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockShareDTO> sellStock(@RequestBody StockShareDTO stockShareSale) {
        StockShareDTO remainingStockShare = stockShareService.sellStock(stockShareSale);
        return new ResponseEntity<>(remainingStockShare, HttpStatus.OK);
    }
}
