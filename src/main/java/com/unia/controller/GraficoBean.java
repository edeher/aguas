package com.unia.controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IMuestraFisoQuimicoService;

@Named
@ViewScoped
public class GraficoBean implements Serializable {

	@Inject
	private MuestraFisoQuimico muestrafisoquimico;
	@Inject
	private IMuestraFisoQuimicoService servicemuestrafisoquimico;

	private LineChartModel lineModel;

	public void listar(MuestraFisoQuimico t) {
		try {

			this.muestrafisoquimico = servicemuestrafisoquimico.listarPorId(t);
			graficar(muestrafisoquimico);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void graficar(MuestraFisoQuimico t) {

			
		lineModel=lineas();
		lineModel.setTitle("Desviacion Standar");
		lineModel.setLegendPosition("e");

		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setMin(1);
		yAxis.setMax(10);
	
	}
	private LineChartModel lineas() {
		LineChartModel model=new LineChartModel();
		
		
		 LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Series 1");
	 
	        series1.set(1, 2);
	        series1.set(2, 1);
	        series1.set(3, 3);
	        series1.set(4, 6);
	        series1.set(5, 8);
		
	        model.addSeries(series1);
	        
	        return model;
	        
	}

	public MuestraFisoQuimico getMuestrafisoquimico() {
		return muestrafisoquimico;
	}

	public void setMuestrafisoquimico(MuestraFisoQuimico muestrafisoquimico) {
		this.muestrafisoquimico = muestrafisoquimico;
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

}
