package com.unia.service;

import java.util.List;

import com.unia.model.FisoQuimico;
import com.unia.model.MuestraFisoQuimico;

public interface IMuestraFisoQuimicoService extends IService<MuestraFisoQuimico>{
	List<MuestraFisoQuimico> listarPorFisoQuimico(FisoQuimico fi) throws Exception;
}
