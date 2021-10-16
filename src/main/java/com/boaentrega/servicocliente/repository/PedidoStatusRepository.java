package com.boaentrega.servicocliente.repository;

import java.util.List;

import com.boaentrega.servicocliente.model.PedidoStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoStatusRepository extends CrudRepository<PedidoStatus, Long> {

    public List<PedidoStatus> findByStatusNot(String status);
}
