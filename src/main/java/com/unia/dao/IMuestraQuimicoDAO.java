package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;

@Local
public interface IMuestraQuimicoDAO extends IDAO<MuestraQuimico>{
	List<MuestraQuimico> listarPorQuimico(Quimico q) throws Exception;
	
}
