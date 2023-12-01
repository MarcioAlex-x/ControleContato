package br.com.controlecontato.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.controlecontato.dto.ContatoDTO;
import br.com.controlecontato.dto.PessoaDTO;
import br.com.controlecontato.model.Contato;
import br.com.controlecontato.model.Pessoa;
import br.com.controlecontato.service.ContatoService;
import br.com.controlecontato.service.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "API Contatos", description = "Aplicação completa com a possibilidade de busca por id, obter uma lista de todos os contatos, criar registro, apagar registro e atualizar registro de contatos")
@RequestMapping("/contato")
public class ContatoResource {

	@Autowired
	ContatoService contatoService;

	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "Ação bem-sucedida", content = {

					@Content(mediaType = "application/json", schema = @Schema(implementation = ContatoDTO.class)) }),

			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	@Operation(summary = "Método responsável por retornar uma lista de contatos")
	@GetMapping
	public ResponseEntity<List<ContatoDTO>> listarContatos() {
		List<ContatoDTO> contatos = contatoService.buscarTodos();
		if (contatos == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(contatos);
	}

	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "Ação bem-sucedida", content = {

					@Content(mediaType = "application/json", schema = @Schema(implementation = ContatoDTO.class)) }),

			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	@Operation(summary = "Método responsável por encontrar um contato")
	@GetMapping("/{id}")
	public ResponseEntity<ContatoDTO> buscarPorId(@PathVariable Long id) throws Exception {
		try {
			ContatoDTO contato = contatoService.buscarPorId(id);
			return ResponseEntity.ok(contato);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por cadastrar um contato")
	@PostMapping
	public ResponseEntity<Contato> salvar(@RequestBody ContatoDTO contato) throws Exception {
		try {
			contatoService.salvar(contato);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por atualizar um contato")
	@PutMapping("/{id}")
	public ResponseEntity<Contato> atualizar(@PathVariable Long id, @RequestBody Contato contato) throws Exception {
		try {
			contatoService.atualizar(id, contato);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por escluir um contato")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) throws Exception {
		try {
			contatoService.deletar(id);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
