package com.example.futures.infra;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange
interface FuturesClient {

    @PostExchange("/futures/Player/hitter.aspx")
    ResponseEntity<String> getFuturesHitterStatPage(
            @RequestBody MultiValueMap<String, String> form,
            @RequestHeader(value = HttpHeaders.COOKIE, required = false) String cookie
    );
}
