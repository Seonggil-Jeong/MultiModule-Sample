package com.sample.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/server")
public class ServerController {

    @Value("${core.info}")
    private String coreInfo;

    @GetMapping("/core")
    public ResponseEntity<String> coreInfo() {
        return ResponseEntity.ok().body(coreInfo);
    }
}
