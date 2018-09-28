package br.desafio.thiago.rest.model;

import java.util.List;

import br.desafio.thiago.rest.controller.FabricanteDao;
import br.desafio.thiago.rest.controller.FuncionarioDao;
import br.desafio.thiago.rest.controller.ProdutoDao;

public class Fachada {

	private static Fachada instancia = null;

	private FuncionarioDao funcionarioDao;

	private FabricanteDao fabricanteDao;
	
	private ProdutoDao produtoDao;

	public Fachada() {

		this.funcionarioDao = new FuncionarioDao();

		this.fabricanteDao = new FabricanteDao();
		
		this.produtoDao = new ProdutoDao();
	}

	public static Fachada getInstancia() {

		if (instancia == null) {

			instancia = new Fachada();
		}

		return instancia;
	}

	public void inserirFuncionario(Funcionario funcionario) {

		this.funcionarioDao.inserir(funcionario);
	}

	public List<Funcionario> listarFuncionario() {

		return this.funcionarioDao.listar();

	}

	public Funcionario buscarFuncionario(Long id) {

		return this.funcionarioDao.buscar(id);
	}

	public void editarFuncionario(Funcionario funcionario) {

		this.funcionarioDao.editar(funcionario);
	}

	public void inserirFabricante(Fabricante fabricante) {

		this.fabricanteDao.inserir(fabricante);
	}

	public List<Fabricante> listarFabricante() {

		return this.fabricanteDao.listar();

	}
	
	public Fabricante buscarFabricante(Long id) {

		return this.fabricanteDao.buscar(id);
	}
	
	public void editarFabricante(Fabricante fabricante) {

		this.fabricanteDao.editar(fabricante);
	}
	
	public void inserirProduto(Produto produto) {
		
		this.produtoDao.inserir(produto);
	}
	
	public List<Produto> listarProduto() {

		return this.produtoDao.listar();

	}
	
	public Produto buscarProduto(Long id) {

		return this.produtoDao.buscar(id);
	}
	
	public void editarProduto(Produto produto) {

		this.produtoDao.editar(produto);
	}

}
