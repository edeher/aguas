package com.unia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct
	public void init() {
		MuestraFisoQuimico fisoquimico= new MuestraFisoQuimico();
		this.listar(fisoquimico);
		
	}
	
	

	public void listar(MuestraFisoQuimico t) {
		try {

			this.muestrafisoquimico = servicemuestrafisoquimico.listarPorId(t);
			graficar(muestrafisoquimico);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
      
	
	private void graficar(MuestraFisoQuimico t1) {
		
			
		lineModel=lineas(t1);
		lineModel.setTitle("Desviacion Estandar");
		lineModel.setAnimate(true);
		lineModel.setLegendPosition("e");

		Axis yAxis1 = lineModel.getAxis(AxisType.Y);
		yAxis1.setMin((t1.getPromedioTo()-t1.getDessoltotal())-1000);
		yAxis1.setMax((t1.getPromedioTo()+t1.getDessoltotal())+1000);
		
		
		
	
	}
	private LineChartModel lineas(MuestraFisoQuimico t2) {
		
			
		
		LineChartModel model=new LineChartModel();
		
			
		 LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Solidos");
	 
	        series1.set(1, t2.getOpsolidostotal1());
	        series1.set(2, t2.getOpsolidostotal2());
	        series1.set(3, t2.getOpsolidostotal3());
	        series1.set(4, t2.getOpsolidostotal4());
	        series1.set(5, t2.getOpsolidostotal5());
	        series1.set(6, t2.getOpsolidostotal6());
		
		 LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Limite Maximo Desviacion");
	 
	        series2.set(1,((t2.getPromedioTo()+t2.getDessoltotal())));
	        series2.set(2, ((t2.getPromedioTo()+t2.getDessoltotal())));
	        series2.set(3, ((t2.getPromedioTo()+t2.getDessoltotal())));
	        series2.set(4, ((t2.getPromedioTo()+t2.getDessoltotal())));
	        series2.set(5, ((t2.getPromedioTo()+t2.getDessoltotal())));
	        series2.set(6, ((t2.getPromedioTo()+t2.getDessoltotal())));
	        
	        
	        LineChartSeries series3 = new LineChartSeries();
	        series3.setLabel("Promedio");
	 
	        series3.set(1, t2.getPromedioTo());
	        series3.set(2, t2.getPromedioTo());
	        series3.set(3, t2.getPromedioTo());
	        series3.set(4, t2.getPromedioTo());
	        series3.set(5,t2.getPromedioTo());
	        series3.set(6, t2.getPromedioTo());
	        
	        LineChartSeries series4 = new LineChartSeries();
	        series4.setLabel("Limite Minimo Desvicion");
	 
	        series4.set(1, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        series4.set(2, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        series4.set(3, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        series4.set(4, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        series4.set(5, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        series4.set(6, ((t2.getPromedioTo()-t2.getDessoltotal())));
	        	        
		
	        model.addSeries(series1);
	        model.addSeries(series2);
	        model.addSeries(series3);
	        model.addSeries(series4);
	        
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
