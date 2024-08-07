package com.example.gerenciamentoclientes.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gerenciamentoclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, UUID>{
	List<Cliente> findByEstado(String estado);
	List<Cliente> findByRepresentante(String representante);
	List<Cliente> findByNomeContaining(String nome);

}
