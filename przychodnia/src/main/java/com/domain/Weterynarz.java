package com.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Weterynarz")
@NamedQueries({ 
	@NamedQuery(name = "weterynarz.getAll", query = "Select w from Weterynarz w")
})

public class Weterynarz 
{
	private Long weterynarzId;
	private String imie;
	private String nazwisko;
	
	private List<Zwierze> zwierzes = new ArrayList<Zwierze>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	public Long getId() {
		return weterynarzId;
	}
	public void setId(Long id) {
		this.weterynarzId = id;
	}
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public List<Zwierze> getZwierzes() {
		return zwierzes;
	}
	public void setZwierzes(List<Zwierze> zwierzes) {
		this.zwierzes = zwierzes;
	}
	

}
