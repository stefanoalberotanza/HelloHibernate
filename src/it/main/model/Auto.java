package it.main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="auto")
public class Auto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String targa;
	@Column(name = "marca")
	private String marca;
	@Column(name = "anno")
	private int anno;
	@Column(name = "chilometri")
	private int chilometri;
	
	@OneToMany(mappedBy = "auto")
	@JsonIgnoreProperties({"auto"})
	private List<Vendite> vendite; 
	
	public List<Vendite> getVendite() {
		return vendite;
	}

	public void setVendite(List<Vendite> vendite) {
		this.vendite = vendite;
	}
	
	public String getTarga() {
		return targa;
	}
	
	public void setTarga(String targa) {
		this.targa = targa;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public int getAnno() {
		return anno;
	}
	
	public void setAnno(int year) {
		this.anno = year;
	}
	
	public int getChilometri() {
		return chilometri;
	}
	
	public void setChilometri(int chilometri) {
		this.chilometri = chilometri;
	}
	
	

	@Override
	public String toString() {
		String messaggio = "Targa: " + this.getTarga() + "\nMarca: " + this.getMarca();
		return messaggio;
	}
}
