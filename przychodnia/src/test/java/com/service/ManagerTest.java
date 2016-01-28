package com.service;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.domain.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional

public class ManagerTest 
{
	
	@Autowired
	Manager manager;
	
	private final String imie1="Azor";
	private final String gatunek1="pies";
	
	private final String imie2="Mruczek";
	private final String gatunek2="kot";
	
	private final String imie3="Jack";
	private final String gatunek3="papuga";
	
	private final String wi1="Zenon";
	private final String wn1="Cwajnos";
	
	
	
	@Test
	public void addZwierzeCheck()
	{
		Zwierze zwierze = new Zwierze();
		zwierze.setImie(imie1);
		zwierze.setGatunek(gatunek1);
		//test dodawanie i pobranie po imieniu
		manager.addZwierze(zwierze);
		Zwierze pobzwierze = manager.findZwierzeByImie(imie1);
		
		assertEquals(imie1, pobzwierze.getImie());
		assertEquals(gatunek1, pobzwierze.getGatunek());
		
	}
	
	@Test
	public void deleteZwierzeCheck()
	{
		Zwierze z1 = new Zwierze();
		z1.setImie(imie1);
		z1.setGatunek(gatunek1);
		
		Zwierze z2 = new Zwierze();
		z2.setImie(imie2);
		z2.setGatunek(gatunek2);
		
		Zwierze z3 = new Zwierze();
		z3.setImie(imie3);
		z3.setGatunek(gatunek3);
		
		manager.addZwierze(z1);
		manager.addZwierze(z2);
		manager.addZwierze(z3);
		
		Zwierze pobrane2 = manager.findZwierzeByImie(imie2);
		manager.deleteZwierze(pobrane2);
		Zwierze kasowane = manager.findZwierzeByImie(imie2);
		
		Zwierze pobrane1 = manager.findZwierzeByImie(imie1);
		Zwierze pobrane3 = manager.findZwierzeByImie(imie3);
		
		assertNull(kasowane);
		assertEquals(imie1, pobrane1.getImie());
		assertEquals(gatunek1, pobrane1.getGatunek());
		assertEquals(imie3, pobrane3.getImie());
		assertEquals(gatunek3, pobrane3.getGatunek());
	}
	
	@Test
	public void findByIdCheck()
	{
		Zwierze z1 = new Zwierze();
		z1.setImie(imie1);
		z1.setGatunek(gatunek1);
		
		manager.addZwierze(z1);
		Zwierze pobraneIm = manager.findZwierzeByImie(imie1);
		Long ID = pobraneIm.getId();
		Zwierze pobraneId = manager.findZwierzeById(ID);
		
		assertEquals(imie1, pobraneId.getImie());
		assertEquals(gatunek1, pobraneId.getGatunek());
	}
	
	@Test
	public void XY()
	{
		Zwierze z1 = new Zwierze();
		z1.setImie(imie1);
		z1.setGatunek(gatunek1);
		
		Zwierze z2 = new Zwierze();
		z2.setImie(imie2);
		z2.setGatunek(gatunek2);
		
		Zwierze z3 = new Zwierze();
		z3.setImie(imie3);
		z3.setGatunek(gatunek3);
		
		Weterynarz w = new Weterynarz();
		w.setImie(wi1);
		w.setNazwisko(wn1);
		
		manager.addZwierze(z2);
		manager.addZwierze(z3);
		w.getZwierzes().add(manager.findZwierzeByImie(imie2));
		w.getZwierzes().add(manager.findZwierzeByImie(imie2));
		manager.addWeterynarz(w);
		
		manager.findWeterynarzByImie(wi1);
		assertEquals(manager.findWeterynarzByImie(wi1).getZwierzes().size(), 2);
		
	}
	@Test
	public void addWeterynarzCheck()
	{
		Weterynarz w = new Weterynarz();
		w.setImie(wi1);
		w.setNazwisko(wn1);
		manager.addWeterynarz(w);
		Weterynarz pobrany = manager.findWeterynarzByImie(wi1);
		assertEquals(pobrany.getImie(), wi1);
	}
	
	

}
