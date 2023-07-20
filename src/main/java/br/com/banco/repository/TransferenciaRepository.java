package br.com.banco.repository;


import br.com.banco.model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia,Long> {
    List<Transferencia> findByNomeOperadorTransacao(String nomeOperadorTransacao);
    List<Transferencia> findByDataTransferenciaBetween(Date start, Date end);

}
