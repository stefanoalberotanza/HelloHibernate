package it.main.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="compratori")
public class Compratore {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_compr")
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cognome")
	private String cognome;
	
	@Column(name="data_nascita")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "compratore")
	@JsonIgnoreProperties({"compratore"})
	private List<Vendite> vendite; 
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public List<Vendite> getVendite() {
		return vendite;
	}

	public void setVendite(List<Vendite> vendite) {
		this.vendite = vendite;
	}
}
