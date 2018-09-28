package br.desafio.thiago.rest.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.desafio.thiago.rest.model.Fachada;
import br.desafio.thiago.rest.model.Funcionario;

public class FuncionarioDaoTest {

	private Fachada fachada;

	private Funcionario funcionario;

	public FuncionarioDaoTest() {

		this.fachada = Fachada.getInstancia();

		this.funcionario = new Funcionario();
	}

	@Test
	@Ignore
	public void inserir() {

		this.funcionario.setNome("Jose");

		this.funcionario.setCpf("333.333.333-33");

		this.funcionario.setFuncao("Gerente");

		this.funcionario.setSenha("45678910");

		this.fachada.inserirFuncionario(funcionario);

	}

	@Test
	@Ignore
	public void listar() {

		List<Funcionario> listagem = this.fachada.listarFuncionario();

		for (Funcionario f : listagem) {

			System.out.println(f.getNome() + " " + f.getCpf() + " " + f.getFuncao() + " " + f.getSenha());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long id = 3L;

		this.funcionario = this.fachada.buscarFuncionario(id);

		if (this.funcionario == null) {

			System.out.println("Funcionario nao encontrado");

		} else {

			System.out.println(funcionario.getNome() + " " + funcionario.getCpf() + " " + funcionario.getFuncao() + " "
					+ funcionario.getSenha());

		}

	}
	
	@Test
	@Ignore
	public void editar() {
		
		Long id = 2L;

		this.funcionario = this.fachada.buscarFuncionario(id);
		
		this.funcionario.setNome("Bruno Manuel");
		
		//this.funcionario.setCpf("333.333.333-33");

		//this.funcionario.setFuncao("Gerente");

		//this.funcionario.setSenha("45678910");


		this.fachada.editarFuncionario(funcionario);

	}

}
