package br.desafio.thiago.rest.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("servico")
public class JerseyConfig extends ResourceConfig{
	
	public JerseyConfig() {
	
		packages("br.desafio.thiago.rest.service");
	}

}
