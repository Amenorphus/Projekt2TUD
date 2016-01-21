package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
 
@Entity
@Table (name = "Zwierze")
@NamedQueries({ 
	@NamedQuery(name = "zwierze.getAll", query = "Select z from Zwierze z")
})

public class Zwierze 
{

	private Long id;
	private String imie;
	private String gatunek;
	private Date dataur;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	
	public String getGatunek() {
		return gatunek;
	}
	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}
	
	
	public Date getDataur() {
		return dataur;
	}
	public void setDataur(Date dataur) {
		this.dataur = dataur;
	}
	
	
}