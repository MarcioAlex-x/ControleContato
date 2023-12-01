package br.com.controlecontato.dto;

import br.com.controlecontato.model.Endereco;

public class EnderecoDTO {
	private String endereco;
	private String cep;
	private String cidade;
	private String uf;
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public EnderecoDTO() {
		super();
	}
	
	public static EnderecoDTO fromEntity(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setCep(endereco.getCep());
		enderecoDTO.setCidade(endereco.getCidade());
		enderecoDTO.setEndereco(endereco.getEndereco());
		enderecoDTO.setUf(endereco.getUf());
		
		return enderecoDTO;
	}
	
}
