package br.com.controlecontato.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.controlecontato.dto.ContatoDTO;
import br.com.controlecontato.dto.PessoaDTO;
import br.com.controlecontato.model.Contato;
import br.com.controlecontato.model.Pessoa;
import br.com.controlecontato.repository.ContatoRepository;
import br.com.controlecontato.service.ContatoService;

@Service
public class ContatoServiceImpl implements ContatoService {
	@Autowired
	ContatoRepository repository;

	@Override
	public void salvar(ContatoDTO contato) {
		Contato novoContato = new Contato();
		novoContato.setTipoContato(contato.getTipoContato());
		repository.save(novoContato);
	}

	@Override
	public ContatoDTO buscarPorId(Long id) throws Exception {

		Optional<Contato> contato = repository.findById(id);
		if (contato.isEmpty()) {
			throw new Exception("Usuário não encontrado");
		}
		ContatoDTO retornoContato = ContatoDTO.fromEntity(contato.get());

		return retornoContato;
	}

	@Override
	public List<ContatoDTO> buscarTodos() {
		List<Contato> contato = repository.findAll();
		List<ContatoDTO> listaRetorno = contato.stream().map(ContatoDTO::fromEntity).toList();
		return listaRetorno;
	}

	@Override
	public void deletar(Long id) throws Exception {
		Optional<Contato> contatoModelo = repository.findById(id);
		if (contatoModelo.isEmpty()) {
			throw new Exception("Usuário não encontrado");
		}
		Contato contato = contatoModelo.get();
		contato.setSituacao(0);
		repository.save(contato);
	}

	@Override
	public void atualizar(Long id, Contato contato) throws Exception {
		Optional<Contato> contatoModelo = repository.findById(id);
		if (contatoModelo.isEmpty()) {
			throw new Exception("Usuário não encontrado");
		}
		if (contatoModelo.isEmpty()) {
			throw new Exception("Usuário não encontrado");

		}

	}

}
