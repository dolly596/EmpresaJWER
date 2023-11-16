package com.projetoprova.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoprova.entities.Produto;
import com.projetoprova.repository.ProdutoRepository;

@Service
public class ProdutoService {
	private ProdutoRepository jwerRepository;

	@Autowired
	public ProdutoService(ProdutoRepository jwerRepository) {
		this.jwerRepository = jwerRepository;
	}

	public List<Produto> buscarTodosProduto() {
		return jwerRepository.findAll();
	}

	public Produto buscarId(Long id) {
		Optional<Produto> Produto = jwerRepository.findById(id);
		return Produto.orElse(null);
	}

	public Produto salvarProduto(Produto jwer) {
		return jwerRepository.save(jwer);
	}

	public Produto alterarProduto(Long id, Produto alterarprod) {
		Optional<Produto> existe = jwerRepository.findById(id);
		if (existe.isPresent()) {
			alterarprod.setId(id);
			return jwerRepository.save(alterarprod);
		}
		return null;
	}

	public boolean apagarProduto(Long id) {
		Optional<Produto> existe = jwerRepository.findById(id);
		if (existe.isPresent()) {
			jwerRepository.deleteById(id);
			return true;
		}

		return false;
	}

}