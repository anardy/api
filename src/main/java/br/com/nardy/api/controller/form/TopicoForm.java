package br.com.nardy.api.controller.form;

import br.com.nardy.api.model.Topico;

public class TopicoForm {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Topico converter(TopicoForm topico) {
		return new Topico(nome);
	}
}
