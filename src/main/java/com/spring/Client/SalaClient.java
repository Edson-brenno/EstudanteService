package com.spring.Client;

import com.spring.Dto.SalasDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "sala-service", url = "http://localhost:8081")
public interface SalaClient {

    @GetMapping("/salas")
    List<SalasDto> getAllSalas();

    @GetMapping("/salas/{id}")
    SalasDto getSalasById(@PathVariable("id") Long id);
}
