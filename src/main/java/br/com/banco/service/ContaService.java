package br.com.banco.service;


import br.com.banco.model.Conta;
import br.com.banco.model.Response;
import br.com.banco.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public ResponseEntity<Response> obterContasExistentes(){
        Response response;
        try {
            List<Conta> contasEncontradas = contaRepository.findAll();
            if (contasEncontradas.isEmpty()){
                response = new Response(204, "Não existem contas criadas.", null);
                return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
            }
            response = new Response(200, "Contas encontradas com sucesso.", contasEncontradas);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        } catch (Exception e){
            response = new Response(500, "Um erro inesperado aconteceu.", null);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
