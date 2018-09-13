package com.unia.service;

import java.util.List;

import com.unia.model.Bacterial;
import com.unia.model.MuestraBacterial;

public interface IMuestraBacterialService extends IService<MuestraBacterial>{
	List<MuestraBacterial> listarPorBacterial(Bacterial b) throws Exception;
}
