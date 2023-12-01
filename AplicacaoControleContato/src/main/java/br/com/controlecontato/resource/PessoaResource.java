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
import br.com.controlecontato.dto.PessoaDTO;
import br.com.controlecontato.model.Pessoa;
import br.com.controlecontato.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "API Pessoas", description = "Aplicação completa com a possibilidade de busca por id, obter a lista de todos as pessoas, criar registro, apagar registro e atualizar registro de pessoas")
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired

	PessoaService pessoaService;

	@ApiResponses(value = {

			@ApiResponse(responseCode = "200", description = "Ação bem-sucedida", content = {

					@Content(mediaType = "application/json", schema = @Schema(implementation = PessoaDTO.class)) }),

			@ApiResponse(responseCode = "500", description = "Erro interno no servidor") })
	@Operation(summary = "Método responsável por retornar uma lista de pessoas")
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> listarPessoas() {
		List<PessoaDTO> pessoas = pessoaService.listarTodos();
		if (pessoas == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoas);
	}

	@ApiResponses(value = {
			  
			  @ApiResponse(responseCode = "200", description = "Ação bem-sucedida",
			  content = {
			  
			  @Content(mediaType = "application/json", schema = @Schema(implementation =
			  PessoaDTO.class)) }),
			  
			  @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
			  })
	@Operation(summary = "Método responsável por encontrar uma pessoa")
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> buscarPorId(@PathVariable Long id) throws Exception {
		try {
			PessoaDTO pessoa = pessoaService.buscarPorId(id);
			return ResponseEntity.ok(pessoa);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por cadastrar uma pessoa")
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody PessoaDTO pessoa) throws Exception {
		try {
			pessoaService.salvar(pessoa);

			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por atualizar uma pessoa")
	@PutMapping("/{id}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody PessoaDTO pessoa) throws Exception {
		try {
			pessoaService.atualizar(id, pessoa);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Operation(summary = "Método responsável por excluir uma pessoa")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) throws Exception {
		try {
			pessoaService.apagar(id);

			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
