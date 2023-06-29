package com.pedrobittencourtcosta.viacep.consultacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("consulta-cep")
public class ConsultaCepApi {

    @GetMapping("{cep}")
    public ConsultaResponseDto consultacep(@PathVariable("cep") String cep) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ConsultaResponseDto> responseDto = restTemplate.getForEntity(String.format("http://viacep.com.br/ws/%s/json/", cep), ConsultaResponseDto.class);
        return responseDto.getBody();
    }

}