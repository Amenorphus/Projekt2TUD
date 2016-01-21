package com.service;

import java.util.List;

import com.domain.*;

public interface Manager 
{
	void addZwierze(Zwierze zwierze);
	List<Zwierze> getAllZwierze();
	void deleteZwierze(Zwierze zwierze);
	Zwierze findZwierzeByImie(String imie);
	
	

}
