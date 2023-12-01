package br.com.controlecontato.service;

import java.util.List;
import java.util.Optional;

import br.com.controlecontato.dto.ContatoDTO;
import br.com.controlecontato.model.Contato;
import br.com.controlecontato.model.Pessoa;

public interface ContatoService {
	void salvar(ContatoDTO contato);
	ContatoDTO buscarPorId(Long id) throws Exception;
	List<ContatoDTO> buscarTodos();
	void deletar(Long id) throws Exception;
	void atualizar(Long id, Contato contato) throws Exception;
}
