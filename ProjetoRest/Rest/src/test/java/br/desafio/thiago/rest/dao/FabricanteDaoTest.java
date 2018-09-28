package br.desafio.thiago.rest.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.desafio.thiago.rest.model.Fabricante;
import br.desafio.thiago.rest.model.Fachada;

public class FabricanteDaoTest {

	private Fachada fachada;

	private Fabricante fabricante;

	public FabricanteDaoTest() {

		this.fachada = Fachada.getInstancia();

		this.fabricante = new Fabricante();
	}

	@Test
	@Ignore
	public void salvar() {

		this.fabricante.setDescricao("LG");

		this.fachada.inserirFabricante(fabricante);
	}

	@Test
	@Ignore
	public void listar() {

		List<Fabricante> listagem = this.fachada.listarFabricante();

		for (Fabricante fabricante : listagem) {

			System.out.println(fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long id = 1L;

		this.fabricante = this.fachada.buscarFabricante(id);

		if (this.fabricante == null) {

			System.out.println("Fabricante nao encontrado");

		} else {

			System.out.println(this.fabricante.getDescricao());

		}

	}

	@Test
	public void editar() {

		Long id = 2L;

		this.fabricante = this.fachada.buscarFabricante(id);

		this.fabricante.setDescricao("Oppo");

		this.fachada.editarFabricante(fabricante);

	}
}
