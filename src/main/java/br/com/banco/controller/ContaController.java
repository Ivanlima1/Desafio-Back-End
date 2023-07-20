package br.com.banco.controller;

import br.com.banco.model.Conta;
import br.com.banco.model.Response;
import br.com.banco.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ContaController {

    @Autowired
    ContaService contaService;

    @GetMapping("/contas")
    public ResponseEntity<Response> getContas(){
        return contaService.obterContasExistentes();
    }

}
