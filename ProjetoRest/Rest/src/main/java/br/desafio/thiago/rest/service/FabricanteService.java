package br.desafio.thiago.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.desafio.thiago.rest.model.Fabricante;
import br.desafio.thiago.rest.model.Fachada;

@Path("fabricante")
public class FabricanteService {

	private Fachada fachada;
	
	public FabricanteService() {
		
		this.fachada = Fachada.getInstancia();
	}
	
	@GET
	public String listar() {
		
		List<Fabricante> lista = this.fachada.listarFabricante();
		
		Gson g = new Gson();
		
		String j = g.toJson(lista);
			
		return j;
	}
	
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		
		Fabricante fabricante = this.fachada.buscarFabricante(codigo);
		
		Gson g = new Gson();
		
		String j = g.toJson(fabricante);
		
		return j;
	}
	
	@POST
	public String salvar(String json) {
		
		Gson g = new Gson();
		
		Fabricante fabricante = g.fromJson(json, Fabricante.class);
		
		this.fachada.inserirFabricante(fabricante);
		
		String saida = g.toJson(fabricante);
		
		return saida;
		
	}
	
}
