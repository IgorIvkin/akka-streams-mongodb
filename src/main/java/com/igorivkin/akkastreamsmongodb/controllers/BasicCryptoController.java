package com.igorivkin.akkastreamsmongodb.controllers;

import com.igorivkin.akkastreamsmongodb.services.CryptoRateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicCryptoController {
    private final CryptoRateService cryptoRateService;

    public BasicCryptoController(CryptoRateService cryptoRateService) {
        this.cryptoRateService = cryptoRateService;
    }

    @GetMapping("/sink/")
    public ResponseEntity<String> launchSinking() {
        cryptoRateService.sinkAndFilter();
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
