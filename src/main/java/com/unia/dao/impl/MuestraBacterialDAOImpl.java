package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IMuestraBacterialDAO;
import com.unia.model.Bacterial;
import com.unia.model.MuestraBacterial;

@Stateless
public class MuestraBacterialDAOImpl implements IMuestraBacterialDAO, Serializable {

	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;

	@Override
	public void registrar(MuestraBacterial t) throws Exception {
		em.persist(t);

	}

	@Override
	public void modificar(MuestraBacterial t) throws Exception {
		em.merge(t);

	}

	@Override
	public List<MuestraBacterial> listar() throws Exception {
		List<MuestraBacterial> lista = new ArrayList<>();

		Query q = em.createQuery("FROM MuestraBacterial mb");
		lista = (List<MuestraBacterial>) q.getResultList();

		return lista;
	}

	@Override
	public MuestraBacterial listarPorId(MuestraBacterial t) throws Exception {
		 List<MuestraBacterial> lista=new ArrayList<>();
			
			Query q=em.createQuery("FROM MuestraBacterial mb where mb.idMuestraBacterial=?1");
			q.setParameter(1, t.getIdMuestraBacterial() );
			lista=(List<MuestraBacterial>)q.getResultList();
			
			MuestraBacterial muestrabacterial=lista!=null&&!lista.isEmpty() ? lista.get(0):new MuestraBacterial();
			
			return muestrabacterial;
	}

	@Override
	public List<MuestraBacterial> listarPorBacterial(Bacterial b) throws Exception {
		List<MuestraBacterial> lista=null;
		
		Query q= em.createQuery("FROM  MuestraBacterial mb where mb.bacterial.idBacterial=?1");
		q.setParameter(1, b.getIdBacterial());
		
		lista=(List<MuestraBacterial>)q.getResultList();
		
				
		return lista;
	}

}
