package br.com.nardy.api.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.nardy.api.controller.dto.TopicoDTO;
import br.com.nardy.api.controller.form.TopicoForm;
import br.com.nardy.api.model.Topico;
import br.com.nardy.api.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	TopicoRepository topicoRepository;
	
	@GetMapping
	public List<Topico> lista() {
		List<Topico> topicos = topicoRepository.findAll();
		return topicos;
		//return TopicoDTO.converter(Arrays.asList(topico));
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> salvar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(form);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getNome()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}

}
