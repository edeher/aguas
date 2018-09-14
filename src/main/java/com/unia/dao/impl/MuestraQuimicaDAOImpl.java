package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IMuestraQuimicoDAO;
import com.unia.model.MuestraFisoQuimico;
import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;

@Stateless
public class MuestraQuimicaDAOImpl implements IMuestraQuimicoDAO, Serializable{

	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;
	
	@Override
	public void registrar(MuestraQuimico t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(MuestraQuimico t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<MuestraQuimico> listar() throws Exception {
		List<MuestraQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM MuestraQuimico mq");
		lista = (List<MuestraQuimico>) q.getResultList();

		return lista;
	}

	@Override
	public MuestraQuimico listarPorId(MuestraQuimico t) throws Exception {
		List<MuestraQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM MuestraQuimico mq where mq.idMuestraQuimico=?1");
		q.setParameter(1, t.getIdMuestraQuimico());
		lista = (List<MuestraQuimico>) q.getResultList();

		MuestraQuimico muestraquimico = lista != null && !lista.isEmpty() ? lista.get(0) : new MuestraQuimico();

		return muestraquimico;
	}

	@Override
	public List<MuestraQuimico> listarPorQuimico(Quimico qi) throws Exception {
			List<MuestraQuimico> lista=null;
		
		Query q= em.createQuery("FROM MuestraQuimico mq where mq.quimico.idQuimico=?1");
		q.setParameter(1, qi.getIdQuimico() );
		
		lista=(List<MuestraQuimico>)q.getResultList();
		
				
		return lista;
	}

}
