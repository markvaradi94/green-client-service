package ro.asis.green.client.service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@EnableEurekaClient
@SpringBootApplication()
class GreenClientServiceApplication {
    @Bean
    @LoadBalanced
    fun restTemplate() = RestTemplate()
}

fun main(args: Array<String>) {
    runApplication<GreenClientServiceApplication>(*args)
}
