package br.com.banco.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@Table(name = "TRANSFERENCIA")
public class Transferencia {

    @Id
    @Column(name = "ID")
    private long Id;

    @Column(name = "DATA_TRANSFERENCIA")
    private Date dataTransferencia;
    @Column(name = "VALOR")
    private BigDecimal valor;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "NOME_OPERADOR_TRANSACAO")
    private String nomeOperadorTransacao;
    @Column(name = "CONTA_ID")
    private int contaId;
}
