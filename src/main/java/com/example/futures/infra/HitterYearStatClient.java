package com.example.futures.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HitterYearStatClient {

    private final FuturesClient futuresClient;

    private final FuturesHitterYearStatParser parser;

    public List<HitterYearStat> getHitterYearStats(final int year) {
        final ResponseEntity<String> response = futuresClient.getFuturesHitterStatPage(new LinkedMultiValueMap(), null);
        return parser.parse(response.getBody());
    }
}
