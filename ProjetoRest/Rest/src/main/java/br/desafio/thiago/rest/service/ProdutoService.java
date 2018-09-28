package br.desafio.thiago.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.desafio.thiago.rest.model.Fachada;
import br.desafio.thiago.rest.model.Produto;

@Path("produto")
public class ProdutoService {

	private Fachada fachada;

	public ProdutoService() {

		this.fachada = Fachada.getInstancia();

	}
	
	@GET
	public String listar() {
		
		List<Produto> lista = this.fachada.listarProduto();
		
		Gson g = new Gson();
		
		String j = g.toJson(lista);
			
		return j;
	}
	
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		
		Produto produto = this.fachada.buscarProduto(codigo);
		
		Gson g = new Gson();
		
		String j = g.toJson(produto);
		
		return j;
	}
	
	@POST
	public String salvar(String json) {
		
		Gson g = new Gson();
		
		Produto produto = g.fromJson(json, Produto.class);
		
		this.fachada.inserirProduto(produto);
		
		String saida = g.toJson(produto);
		
		return saida;
		
	}
}
