package br.com.banco.service;

import br.com.banco.model.Response;
import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.utils.Erro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class TransferenciaService {
    @Autowired
    private TransferenciaRepository transferenciaRepository;

    public ResponseEntity<Object> obterTransferencias(){
        try {
            List<Transferencia> transferencias = transferenciaRepository.findAll();
            if (transferencias.isEmpty()){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Não há transferências.");
            }
            return ResponseEntity.ok(transferencias);
        }catch (Exception e){
            List<Erro> erros = new ArrayList<>();
            Erro erro = new Erro();
            erro.setCodigo(500);
            erro.setMensagem(e.getMessage());
            erros.add(erro);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erros);
        }
    }

    public ResponseEntity<List<?>> obterTransferenciaFiltrada(String dataInicio, String dataFinal, String operador){
        try {
            if(dataInicio != null && dataFinal != null){
                Date dInicioFormatado = dateGenerator(dataInicio);
                Date dFinalFormatado = dateGenerator(dataFinal);
                List<Transferencia> transferenciasFiltradas = transferenciaRepository.findByDataTransferenciaBetween(dInicioFormatado, dFinalFormatado);
                if(!Objects.isNull(operador)){
                    transferenciasFiltradas = transferenciasFiltradas.stream().filter(e -> e.getNomeOperadorTransacao().equals(operador)).collect(Collectors.toList());
                }
                return ResponseEntity.ok(transferenciasFiltradas);
            }
            List<Transferencia> transferenciasFiltradas = transferenciaRepository.findByNomeOperadorTransacao(operador);
            return ResponseEntity.ok(transferenciasFiltradas);

        } catch (Exception e){
            List<Erro> erros = new ArrayList<>();
            Erro erro = new Erro();
            erro.setCodigo(500);
            erro.setMensagem(e.getMessage());
            erros.add(erro);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erros);
        }
    }

    private Date dateGenerator(String data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] s = data.split("/");
        int ano = Integer.parseInt(s[2]);
        int mes = Integer.parseInt(s[1])-1;
        int dia = Integer.parseInt(s[0]);
        Calendar cal = Calendar.getInstance();
        cal.set(ano, mes, dia, 00, 00);

        return cal.getTime();
    }

}
