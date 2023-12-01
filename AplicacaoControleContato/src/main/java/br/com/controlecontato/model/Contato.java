package br.com.controlecontato.model;

import java.util.Objects;

import br.com.controlecontato.dto.ContatoDTO;
import br.com.controlecontato.enumeration.TipoContato;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.ORDINAL)
	private TipoContato tipoContato;
	private String contato;

	@ManyToOne
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	// Construtores
	public Contato() {
	}

	public Contato(Long id, TipoContato tipoContato, String contato, Pessoa pessoa) {
		super();
		this.id = id;
		this.tipoContato = tipoContato;
		this.contato = contato;
		this.pessoa = pessoa;
	}

	private Integer situacao;

	@PrePersist
	private void prePersist() {
		setSituacao(1);
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	// Getters e Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoContato getTipoContato() {
		return tipoContato;
	}

	public void setTipoContato(TipoContato tipoContato) {
		this.tipoContato = tipoContato;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	// HashCode e Equals
	@Override
	public int hashCode() {
		return Objects.hash(contato, id, pessoa, tipoContato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(contato, other.contato) && Objects.equals(id, other.id)
				&& Objects.equals(pessoa, other.pessoa) && tipoContato == other.tipoContato;
	}

	public static ContatoDTO fromEntity(Contato contato) {
		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setTipoContato(contato.getTipoContato());
		contatoDTO.setContato(contato.getContato());

		return contatoDTO;
	}

}
