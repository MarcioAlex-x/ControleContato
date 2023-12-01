package br.com.controlecontato.dto;

import java.util.List;

import br.com.controlecontato.model.Contato;
import br.com.controlecontato.model.Pessoa;

public class PessoaDTO {
	private String nome;
	private String cpf;
	private Integer idade;
	private EnderecoDTO endereco;
	private List<ContatoDTO> contatos;
	
	public PessoaDTO() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	public List<ContatoDTO> getContatos() {
		return contatos;
	}
	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}
	
	public static PessoaDTO fromEntity(Pessoa pessoa) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setIdade(pessoa.getIdade());
		pessoaDTO.setCpf(pessoa.getCpf());
		pessoaDTO.setEndereco(EnderecoDTO.fromEntity(pessoa.getEndereco()));
		
		List<Contato> contatos = pessoa.getContatos();
		List<ContatoDTO> listaContato = contatos.stream().map(ContatoDTO::fromEntity).toList();
		
		pessoaDTO.setContatos(listaContato);
		
		return pessoaDTO;
	}
	
	
}
