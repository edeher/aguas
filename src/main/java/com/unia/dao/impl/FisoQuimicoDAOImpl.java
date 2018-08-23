package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IFisoQuimicoDAO;
import com.unia.model.FisoQuimico;

@Stateless
public class FisoQuimicoDAOImpl implements IFisoQuimicoDAO, Serializable {

	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;

	@Override
	public void registrar(FisoQuimico t) throws Exception {
		em.persist(t);

	}

	@Override
	public void modificar(FisoQuimico t) throws Exception {
		em.merge(t);

	}

	@Override
	public List<FisoQuimico> listar() throws Exception {
		List<FisoQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM FisoQuimico f");
		lista = (List<FisoQuimico>) q.getResultList();

		return lista;
	}

	@Override
	public FisoQuimico listarPorId(FisoQuimico t) throws Exception {
		List<FisoQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM FisoQuimico f where f.idFisoQuimico=?1");
		q.setParameter(1, t.getIdFisoQuimico());
		lista = (List<FisoQuimico>) q.getResultList();

		FisoQuimico fisoquimico = lista != null && !lista.isEmpty() ? lista.get(0) : new FisoQuimico();

		return fisoquimico;
	}

}
