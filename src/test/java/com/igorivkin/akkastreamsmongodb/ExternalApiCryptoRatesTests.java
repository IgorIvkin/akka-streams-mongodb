package com.igorivkin.akkastreamsmongodb;

import com.igorivkin.akkastreamsmongodb.entities.CryptoRate;
import com.igorivkin.akkastreamsmongodb.services.ExternalApiCryptoRatesService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ExternalApiCryptoRatesTests {

    @Autowired
    private ExternalApiCryptoRatesService externalApiCryptoRatesService;

    @Test
    public void sourceGenerationTest() {
        List<CryptoRate> generatedList = externalApiCryptoRatesService.getCryptoRates();
        assertEquals(generatedList.size(), 10);
    }
}
