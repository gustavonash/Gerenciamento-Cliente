package com.example.gerenciamentoclientes.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String nome;
	private String estado;
	private String representante;

	public Cliente() {
	}

	public Cliente(String nome, String estado, String representante) {
		this.nome = nome;
		this.estado = estado;
		this.representante = representante;
	}

}
