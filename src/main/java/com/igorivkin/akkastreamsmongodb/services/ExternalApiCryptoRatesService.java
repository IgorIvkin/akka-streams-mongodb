package com.igorivkin.akkastreamsmongodb.services;

import com.igorivkin.akkastreamsmongodb.entities.CryptoRate;

import java.util.List;

public interface ExternalApiCryptoRatesService {
    public List<CryptoRate> getCryptoRates();
}
