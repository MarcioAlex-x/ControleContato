package br.com.controlecontato.service;

import java.util.List;
import java.util.Optional;

import br.com.controlecontato.dto.PessoaDTO;
import br.com.controlecontato.model.Pessoa;

public interface PessoaService {
	void salvar(PessoaDTO pessoa);
	PessoaDTO buscarPorId(Long id) throws Exception;
	List<PessoaDTO> listarTodos();
	void atualizar(Long id, PessoaDTO pessoa) throws Exception;
	void apagar(Long id) throws Exception;
}
