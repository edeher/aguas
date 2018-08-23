package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.model.Quimico;

@Stateless
public class QuimicoDAOImpl implements IQuimicoDAO, Serializable {

	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;
	
	@Override
	public void registrar(Quimico t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(Quimico t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<Quimico> listar() throws Exception {
		List<Quimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Quimico q");
		lista = (List<Quimico>) q.getResultList();

		return lista;
	}

	@Override
	public Quimico listarPorId(Quimico t) throws Exception {
		List<Quimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM Quimico q where q.idQuimico=?1");
		q.setParameter(1, t.getIdQuimico());
		lista = (List<Quimico>) q.getResultList();

		Quimico quimico = lista != null && !lista.isEmpty() ? lista.get(0) : new Quimico();

		return quimico;
	}

}
