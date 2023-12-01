package br.com.controlecontato.dto;

import br.com.controlecontato.enumeration.TipoContato;
import br.com.controlecontato.model.Contato;

public class ContatoDTO {
	private String contato;
	private TipoContato tipoContato;
	
	public ContatoDTO() {
		super();
	}
	
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public TipoContato getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}
	
	public static ContatoDTO fromEntity(Contato contato) {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setTipoContato(contato.getTipoContato());
		contatoDTO.setContato(contato.getContato());
		
		return contatoDTO;
	}
	
	
}
