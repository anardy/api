package br.com.nardy.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.nardy.api.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
