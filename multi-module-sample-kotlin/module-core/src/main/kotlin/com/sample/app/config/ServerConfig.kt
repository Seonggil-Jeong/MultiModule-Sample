package com.sample.app.config

import org.springframework.stereotype.Component

@Component
class ServerConfig {

    fun getCoreVersion(): String = "v0.0.1"

}