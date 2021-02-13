package com.igorivkin.akkastreamsmongodb;

import com.igorivkin.akkastreamsmongodb.services.CryptoRateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CryptoRateServiceTests {

    @Autowired
    private CryptoRateService cryptoRateService;

    @Test
    public void basicSinkTest() {
        cryptoRateService.sinkAndFilter();
    }

}
