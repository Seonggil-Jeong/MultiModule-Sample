package com.sample.app

import com.sample.app.config.ServerConfig
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/server"])
class ServerController(val serverConfig: ServerConfig) {


    @RequestMapping(value = ["/core/version"])
    fun getCoreInfo(): ResponseEntity<String> = ResponseEntity.ok().body(serverConfig.getCoreVersion())
}