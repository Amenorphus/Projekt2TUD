package com.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.domain.*;

@Component
@Transactional
public class ManagerImpl implements Manager
{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addZwierze(Zwierze zwierze) {
		zwierze.setId(null);
		sessionFactory.getCurrentSession().persist(zwierze);
	}
	
	@Override
	public Zwierze findZwierzeById(Long id) {
		return (Zwierze) sessionFactory.getCurrentSession().get(Zwierze.class, id);
	}
	
	@Override
	public void deleteZwierze(Zwierze zwierze) {
		
		sessionFactory.getCurrentSession().delete(zwierze);
	}



}
