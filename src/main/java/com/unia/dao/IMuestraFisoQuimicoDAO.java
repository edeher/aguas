package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;

@Local
public interface IMuestraFisoQuimicoDAO extends IDAO<MuestraFisoQuimico>{

	List<MuestraFisoQuimico> listarPorFisoQuimico(FisoQuimico fi) throws Exception;
	
}
