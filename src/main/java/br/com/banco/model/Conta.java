package br.com.banco.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @Column(name = "ID_CONTA")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long IdConta;

    @Column(name = "NOME_RESPONSAVEL")
    private String nomeResponsavel;

}
