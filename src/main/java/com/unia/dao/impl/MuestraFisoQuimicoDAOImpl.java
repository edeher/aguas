package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IMuestraFisoQuimicoDAO;
import com.unia.model.FisoQuimico;
import com.unia.model.MuestraBacterial;
import com.unia.model.MuestraFisoQuimico;

@Stateless
public class MuestraFisoQuimicoDAOImpl implements IMuestraFisoQuimicoDAO, Serializable{

	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;
	
	@Override
	public void registrar(MuestraFisoQuimico t) throws Exception {
		em.persist(t);
		
	}

	@Override
	public void modificar(MuestraFisoQuimico t) throws Exception {
		em.merge(t);
		
	}

	@Override
	public List<MuestraFisoQuimico> listar() throws Exception {
		List<MuestraFisoQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM MuestraFisoQuimico mf");
		lista = (List<MuestraFisoQuimico>) q.getResultList();

		return lista;
	}

	@Override
	public MuestraFisoQuimico listarPorId(MuestraFisoQuimico t) throws Exception {
		List<MuestraFisoQuimico> lista = new ArrayList<>();

		Query q = em.createQuery("FROM MuestraFisoQuimico mf where mf.idMuestraFisoQuimico=?1");
		q.setParameter(1, t.getIdMuestraFisoQuimico());
		lista = (List<MuestraFisoQuimico>) q.getResultList();

		MuestraFisoQuimico muestrafisoquimico = lista != null && !lista.isEmpty() ? lista.get(0) : new MuestraFisoQuimico();

		return muestrafisoquimico;
	}

	@Override
	public List<MuestraFisoQuimico> listarPorFisoQuimico(FisoQuimico fi) throws Exception {
		List<MuestraFisoQuimico> lista=null;
		
		Query q= em.createQuery("FROM MuestraFisoQuimico mf where mf.fisoQuimico.idFisoQuimico?1");
		q.setParameter(1, fi.getIdFisoQuimico());
		
		lista=(List<MuestraFisoQuimico>)q.getResultList();
		
				
		return lista;
	}

}
