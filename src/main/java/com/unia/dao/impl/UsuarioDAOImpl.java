package com.unia.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.unia.dao.IUsuarioDAO;
import com.unia.model.Usuario;

@Stateless
public class UsuarioDAOImpl implements IUsuarioDAO,Serializable{
	
	
	@PersistenceContext(unitName = "Aguas")
	private EntityManager em;

	@Override
	public void registrar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario listarPorId(Usuario t) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario iniciarSesion(Usuario usuario) {
		List<Usuario> lista=new ArrayList<>();
		
		Query q=em.createQuery("FROM Usuario u where u.usuario=?1 and u.clave=?2");
		q.setParameter(1, usuario.getUsuario());
		q.setParameter(2, usuario.getClave());
		
		lista=(List<Usuario>)q.getResultList();
		
		Usuario usuario1=lista!=null&&!lista.isEmpty() ? lista.get(0):new Usuario();
		
		return usuario1;
	}

}
