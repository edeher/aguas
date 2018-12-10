package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.unia.model.Menu;
import com.unia.model.Usuario;
import com.unia.service.IMenuService;

@Named
@SessionScoped
public class MenuBean implements Serializable{
	
	
	@Inject
	private Menu menu;
	
	@Inject
	private IMenuService servicemenu;
	
	private MenuModel model;
	
	private List<Menu> lstMenu;
	
	@PostConstruct
	public void init() {
		
		lstMenu =new  ArrayList<>();
		this.listarMenus();
		
		model= new DefaultMenuModel();
		this.establecerPermisos();
	}
	
	public void listarMenus() {
		
		try {
			
			lstMenu=servicemenu.listar();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void establecerPermisos() {
		
		Usuario us=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
		
		for(Menu m : this.lstMenu) {
			
			if(m.getTipo().equals("S") && m.getTipoUsuario().equals(us.getTipo())) {
				
				DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
				for(Menu i : this.lstMenu) {
					
					Menu submenu=i.getSubmenu();
					if(submenu != null) {
						if(submenu.getIdMenu()==m.getIdMenu()) {
							 DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
							 item.setUrl(i.getUrl());
							 firstSubmenu.addElement(item);
						}
						
					}
					
				}
				model.addElement(firstSubmenu);
				
			}else {
				
				if(m.getSubmenu()==null && m.getTipoUsuario().equals(us.getTipo())) {
					
					DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
					item.setUrl(m.getUrl());
					model.addElement(item);
					
				}
				
			}
		}
	}
	
	public void cerrarSesion() {
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Menu> getLstMenu() {
		return lstMenu;
	}

	public void setLstMenu(List<Menu> lstMenu) {
		this.lstMenu = lstMenu;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
	
	
	
	

}
