package com.igorivkin.akkastreamsmongodb.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class CryptoRate {
    private UUID _id;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createdAt;
    private String cryptoName;
    private Double rateToUSD;
}
