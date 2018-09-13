package com.unia.service;

import java.util.List;

import com.unia.model.MuestraQuimico;
import com.unia.model.Quimico;

public interface IMuestraQuimicoService extends IService<MuestraQuimico>{
	List<MuestraQuimico> listarPorQuimico(Quimico q) throws Exception;
}
