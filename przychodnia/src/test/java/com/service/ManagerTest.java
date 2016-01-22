package com.service;

import static org.junit.Assert.assertEquals;

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
	
	
	
	@Test
	public void addZwierzeCheck()
	{
		Zwierze zwierze = new Zwierze();
		zwierze.setImie(imie1);
		zwierze.setGatunek(gatunek1);
		
		manager.addZwierze(zwierze);
		Zwierze pobzwierze = manager.findZwierzeByImie(imie1);
		
		assertEquals(imie1, pobzwierze.getImie());
		assertEquals(gatunek2, pobzwierze.getGatunek());
		
	}

}
