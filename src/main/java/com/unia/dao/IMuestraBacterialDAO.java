package com.unia.dao;

import java.util.List;

import javax.ejb.Local;

import com.unia.model.Bacterial;
import com.unia.model.MuestraBacterial;

@Local
public interface IMuestraBacterialDAO extends IDAO<MuestraBacterial> {

	List<MuestraBacterial> listarPorBacterial(Bacterial b) throws Exception;
}
