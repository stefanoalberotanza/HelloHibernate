package it.main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="vendite")
public class Vendite {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Column(name="prezzo")
	private int prezzo; 

	@ManyToOne
	@JoinColumn(name = "id_compr")
	@JsonIgnoreProperties({"vendite"})
	private Compratore compratore;

	@ManyToOne
	@JoinColumn(name = "targa")
	@JsonIgnoreProperties({"vendite"})
	private Auto auto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Compratore getCompratore() {
		return compratore;
	}

	public void setCompratore(Compratore compratore) {
		this.compratore = compratore;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}
}
