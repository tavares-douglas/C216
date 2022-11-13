package br.inatel.labs.labrest_client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.labs.labrest_client.model.Curso;
import reactor.core.publisher.Flux;

public class WebClientGetCurso
{
	public static void main(String[] args)
	{
		List<Curso> listaDeCursos = new ArrayList<Curso>();
		
		Flux<Curso> fluxCurso = WebClient.create("http://localhost:8080")
		.get()
		.uri("/curso")
		.retrieve()
		.bodyToFlux(Curso.class);
		
		fluxCurso.subscribe(c -> listaDeCursos.add(c));
		
		fluxCurso.blockLast();
		
		System.out.println("Lista de Cursos: ");
		System.out.println(listaDeCursos);
	}
}
