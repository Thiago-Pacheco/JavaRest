package br.desafio.thiago.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.desafio.thiago.rest.model.Fachada;
import br.desafio.thiago.rest.model.Funcionario;

@Path("funcionario")
public class FuncionarioService {
	
	private Fachada fachada;
	
	public FuncionarioService() {
	
		this.fachada = Fachada.getInstancia();
	}

	@GET
	public String listar() {
		
		List<Funcionario> lista = this.fachada.listarFuncionario();
		
		Gson g = new Gson();
		
		String j = g.toJson(lista);
			
		return j;
	}
	
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		
		Funcionario funcionario = this.fachada.buscarFuncionario(codigo);
		
		Gson g = new Gson();
		
		String j = g.toJson(funcionario);
		
		return j;
	}
	
	@POST
	public String salvar(String json) {
		
		Gson g = new Gson();
		
		Funcionario funcionario = g.fromJson(json, Funcionario.class);
		
		this.fachada.inserirFuncionario(funcionario);
		
		String saida = g.toJson(funcionario);
		
		return saida;
		
	}
	
	
}
