package br.com.controlecontato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.controlecontato.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
