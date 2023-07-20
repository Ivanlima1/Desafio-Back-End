package br.com.banco.controller;


import br.com.banco.model.Response;
import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransferenciaController {

    @Autowired
    TransferenciaService transferenciaService;

    @GetMapping("/transferencias")

    public ResponseEntity<Object> getContas(){
        return transferenciaService.obterTransferencias();
    }

    @GetMapping("/transferenciasfiltro")
    public ResponseEntity<List<?>> getContasComFiltro(@RequestParam(required = false, name = "dataI") String dataInicio, @RequestParam(required = false, name = "dataF") String dataFinal, @RequestParam(required = false) String operador){
        return transferenciaService.obterTransferenciaFiltrada(dataInicio,dataFinal,operador);
        //return new ResponseEntity<>(operador, HttpStatus.OK);


    }

}
