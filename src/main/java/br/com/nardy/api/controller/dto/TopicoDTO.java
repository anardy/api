package br.com.nardy.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.nardy.api.model.Topico;

public class TopicoDTO {

	private String nome;
	
	public TopicoDTO(Topico topico) {
		this.nome = topico.getNome();
	}

	public String getNome() {
		return nome;
	}

	public static List<TopicoDTO> converter(List<Topico> topicos) {
		return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
	}
}
