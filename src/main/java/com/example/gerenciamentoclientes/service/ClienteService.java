package com.example.gerenciamentoclientes.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gerenciamentoclientes.model.Cliente;
import com.example.gerenciamentoclientes.repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(UUID id) {
		return clienteRepository.findById(id).orElse(null);
	}

//	public Cliente save(Cliente cliente) {
//		return clienteRepository.save(cliente);
//	}

	public List<Cliente> saveAll(List<Cliente> clientes) {
		return clienteRepository.saveAll(clientes);
	}

	public void deleteById(UUID id) {
		clienteRepository.deleteById(id);
	}

	public boolean existsById(UUID id) {
		return clienteRepository.existsById(id);
	}

	public List<Cliente> findByEstado(String estado) {
		return clienteRepository.findByEstado(estado);
	}

	public List<Cliente> findByRepresentante(String representante) {
		return clienteRepository.findByRepresentante(representante);
	}

	public List<Cliente> findByNomeContaining(String nome) {
		return clienteRepository.findByNomeContaining(nome);
	}

	public Cliente update(UUID id, Cliente cliente) {
		Cliente existingCliente = clienteRepository.findById(id).orElse(null);
		if (existingCliente != null) {
			cliente.setId(id);
			return clienteRepository.save(cliente);
		}
		return null;
	}

}
