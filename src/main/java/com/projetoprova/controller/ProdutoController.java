package com.projetoprova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoprova.entities.Produto;
import com.projetoprova.service.ProdutoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/produto")
public class ProdutoController {
	private final ProdutoService jwerService;

	@Autowired
	public ProdutoController(ProdutoService jwerService) {
		this.jwerService = jwerService;
	}

	@GetMapping("/{id}")
	@Operation(summary = "Localiza usuario por ID")
	public ResponseEntity<Produto> buscarId(@PathVariable Long id) {
		Produto pedido = jwerService.buscarId(id);
		if (pedido != null) {
			return ResponseEntity.ok(pedido);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	@Operation(summary = "Apresenta todos os usuarios")
	public ResponseEntity<List<Produto>> buscarTodosProduto() {
		List<Produto> usuario = jwerService.buscarTodosProduto();
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	@Operation(summary = "Inserindo Dados")
	public ResponseEntity<Produto> salvarProduto(@RequestBody @Valid Produto usuario) {
		Produto salvar = jwerService.salvarProduto(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
	}

	@PutMapping
	@Operation(summary = "Aterando Dados")
	public ResponseEntity<Produto> alterarProduto(@PathVariable Long id, @RequestBody @Valid Produto produto) {
		Produto alterar = jwerService.alterarProduto(id, produto);
		if (alterar != null) {
			return ResponseEntity.ok(produto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletando Dados")
	public ResponseEntity<Produto> apagarProduto(@PathVariable Long id) {
		boolean apagar = jwerService.apagarProduto(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}