package br.desafio.thiago.rest.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.desafio.thiago.rest.model.Fabricante;
import br.desafio.thiago.rest.model.Fachada;
import br.desafio.thiago.rest.model.Produto;

public class ProdutoDaoTest {

	private Produto produto;

	private Fabricante fabricante;

	private Fachada fachada;

	public ProdutoDaoTest() {

		this.produto = new Produto();

		this.fabricante = new Fabricante();

		this.fachada = Fachada.getInstancia();
	}

	@Test
	@Ignore
	public void salvar() {
		
		this.fabricante = this.fachada.buscarFabricante(1L);

		this.produto.setDescricao("iPhone x");

		this.produto.setPreco(new BigDecimal("3.500"));

		this.produto.setQuantidade(10);

		this.produto.setFabricante(fabricante);
		
		this.fachada.inserirProduto(produto);
	}
	
	@Test
	@Ignore
	public void listar() {

		List<Produto> listagem = this.fachada.listarProduto();

		for (Produto produto : listagem) {

			System.out.println(produto.getDescricao() + " " + produto.getPreco() + " " + produto.getQuantidade() + " " 
			+ produto.getFabricante().getId());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		
		Long id = 1L;
		
		this.produto = this.fachada.buscarProduto(id);
		
		System.out.println(produto.getDescricao() + " " + produto.getPreco() + " " + produto.getQuantidade() + " " 
				+ produto.getFabricante().getId());
		
	}
	
	@Test
	@Ignore
	public void editar() {
		
		this.produto = this.fachada.buscarProduto(1L);
		
		this.produto.setDescricao("iPhone x");

		this.produto.setPreco(new BigDecimal("3.500"));

		this.produto.setQuantidade(10);

		this.produto.getFabricante().setId(3L);;
		
		this.fachada.editarProduto(produto);
		
		
	}
	
	

}
