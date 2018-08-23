package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IBacterialDAO;
import com.unia.model.Bacterial;

@Stateless
public class BacterialDAOImpl implements IBacterialDAO, Serializable{

	@PersistenceContext(unitName="Aguas")
	private EntityManager em;
	
	@Override
	public void registrar(Bacterial t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Bacterial t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Bacterial> listar() throws Exception {
		List<Bacterial> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Bacterial b");
		lista=(List<Bacterial>)q.getResultList();
		
		return lista;
	}

	@Override
	public Bacterial listarPorId(Bacterial t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
