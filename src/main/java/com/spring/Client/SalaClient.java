package com.spring.Client;

import com.spring.Dto.SalasDto;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@FeignClient(name = "sala-service")
public interface SalaClient {

    @GetMapping("/salas")
    @Retry(name = "default", fallbackMethod = "fallbackGetAllSalas")
    List<SalasDto> getAllSalas();

    @GetMapping("/salas/{id}")
    SalasDto getSalasById(@PathVariable("id") Long id);

    // Fallback method must match the return type and accept the same parameters as the original method
    default List<SalasDto> fallbackGetAllSalas(Throwable throwable) {
        // Log the error if needed
        System.out.println("Fallback called due to: " + throwable.getMessage());
        return Collections.emptyList(); // Return an empty list or handle as needed
    }
}
