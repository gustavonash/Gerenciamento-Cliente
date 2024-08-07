package com.example.gerenciamentoclientes.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerenciamentoclientes.model.Cliente;
import com.example.gerenciamentoclientes.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable UUID id) {
		Cliente cliente = clienteService.findById(id);
		return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<List<Cliente>> createCliente(@RequestBody List<Cliente> clientes) {
		 List<Cliente> savedClientes = clienteService.saveAll(clientes);
		 return ResponseEntity.status(HttpStatus.CREATED).body(savedClientes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable UUID id, @RequestBody Cliente cliente) {
		Cliente updatedCliente = clienteService.update(id, cliente);
		return updatedCliente != null ? ResponseEntity.ok(updatedCliente) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable UUID id) {
		if (clienteService.existsById(id)) {
			clienteService.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/estado/{estado}")
	public List<Cliente> getClientesByEstado(@PathVariable String estado) {
		return clienteService.findByEstado(estado);
	}

	@GetMapping("/representante/{representante}")
	public List<Cliente> getClientesByRepresentante(@PathVariable String representante) {
		return clienteService.findByRepresentante(representante);
	}

	@GetMapping("/nome/{nome}")
	public List<Cliente> getClientesByNome(@PathVariable String nome) {
		return clienteService.findByNomeContaining(nome);
	}
}
