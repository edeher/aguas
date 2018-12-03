package com.unia.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

import com.unia.model.MuestraFisoQuimico;
import com.unia.service.IMuestraFisoQuimicoService;

@Named
@ViewScoped
public class GraficoBean implements Serializable {

	@Inject
	private MuestraFisoQuimico muestrafisoquimico;
	@Inject
	private IMuestraFisoQuimicoService servicemuestrafisoquimico;

	private LineChartModel lineModel1;
	private LineChartModel lineModel2;
	private LineChartModel lineModel3;
	private BarChartModel barModel;
	private CartesianChartModel combinedModel;
	
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
//		double max=0;
//		List<Double> lista1= new ArrayList<>();
//		lista1.add(t1.getOpsolidostotal1());
//		lista1.add(t1.getOpsolidostotal2());
//		lista1.add(t1.getOpsolidostotal3());
//		lista1.add(t1.getOpsolidostotal4());
//		lista1.add(t1.getOpsolidostotal5());
//		lista1.add(t1.getOpsolidostotal6());
//		
//		for(int i=0; i<lista1.size();i++) {
//			if(lista1.get(i)>max) {
//				max=lista1.get(i);
//			}
//		}
//		double min=max;
//		for(int i=0; i<lista1.size();i++) {
//			if(lista1.get(i)<min) {
//				min=lista1.get(i);
//			}
//		}
//		System.out.println("maximo :"+max+" y minimo :"+min);
			
		lineModel1=lineas1(t1);
		lineModel1.setTitle("Desviacion Estandar Solidos Totales");
		lineModel1.setAnimate(true);
		lineModel1.setLegendPosition("ne");

		Axis yAxis1 = lineModel1.getAxis(AxisType.Y);
		yAxis1.setMin((t1.getPromedioTo()-t1.getDessoltotal())-10);
		yAxis1.setMax((t1.getPromedioTo()+t1.getDessoltotal())+10);
		
		
		
		lineModel2=lineas2(t1);
		lineModel2.setTitle("Desviacion Estandar Solidos Fijos");
		lineModel2.setAnimate(true);
		lineModel2.setLegendPosition("ne");

		Axis yAxis2= lineModel2.getAxis(AxisType.Y);
		yAxis2.setMin((t1.getPromedioFi()-t1.getDessolfi())-10);
		yAxis2.setMax((t1.getPromedioFi()+t1.getDessolfi())+10);
		
		
		
		lineModel3=lineas3(t1);
		lineModel3.setTitle("Desviacion Estandar Solidos Volatiles");
		lineModel3.setAnimate(true);
		lineModel3.setLegendPosition("ne");

		Axis yAxis3 = lineModel3.getAxis(AxisType.Y);
		yAxis3.setMin((t1.getPromedioVo()-t1.getDessolvol())-10);
		yAxis3.setMax((t1.getPromedioVo()+t1.getDessolvol())+10);
		
		
		
		barModel = lineas4(t1);
		barModel.setTitle("Porcentaje de Solidos");
		barModel.setAnimate(true);
        barModel.setLegendPosition("ne");
        Axis xAxis4 = barModel.getAxis(AxisType.X);
        xAxis4.setLabel("Muestras");
        Axis yAxis4 = barModel.getAxis(AxisType.Y);
        yAxis4.setLabel("Porcentaje");
        yAxis4.setMin(0);
        yAxis4.setMax(((t1.getPromedioVo()+t1.getDessolvol())+8)/100);
        
        
        
        combinedModel=lineas5(t1);
        combinedModel.setTitle("Porcentaje de Solidos");
        combinedModel.setAnimate(true);
        combinedModel.setLegendPosition("ne");
        combinedModel.setMouseoverHighlight(false);
        combinedModel.setShowDatatip(false);
        combinedModel.setShowPointLabels(true);
        Axis xAxis5 = combinedModel.getAxis(AxisType.X);
        xAxis5.setLabel("Muestras");
        Axis yAxis5 = combinedModel.getAxis(AxisType.Y);
        yAxis5.setLabel("Porcentaje");
        yAxis5.setMin(0);
        yAxis5.setMax(((t1.getPromedioVo()+t1.getDessolvol())+8)/100);
		
			
	}
	private LineChartModel lineas1(MuestraFisoQuimico l1) {
		
			
		
		LineChartModel model=new LineChartModel();
		
			
		 LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Solidos");
	 
	        series1.set(1, l1.getOpsolidostotal1());
	        series1.set(2, l1.getOpsolidostotal2());
	        series1.set(3, l1.getOpsolidostotal3());
	        series1.set(4, l1.getOpsolidostotal4());
	        series1.set(5, l1.getOpsolidostotal5());
	        series1.set(6, l1.getOpsolidostotal6());
		
		 LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Limite Maximo Desviacion");
	 
	        series2.set(1,((l1.getPromedioTo()+l1.getDessoltotal())));
	        series2.set(2, ((l1.getPromedioTo()+l1.getDessoltotal())));
	        series2.set(3, ((l1.getPromedioTo()+l1.getDessoltotal())));
	        series2.set(4, ((l1.getPromedioTo()+l1.getDessoltotal())));
	        series2.set(5, ((l1.getPromedioTo()+l1.getDessoltotal())));
	        series2.set(6, ((l1.getPromedioTo()+l1.getDessoltotal())));
	        
	        
	        LineChartSeries series3 = new LineChartSeries();
	        series3.setLabel("Promedio");
	 
	        series3.set(1, l1.getPromedioTo());
	        series3.set(2, l1.getPromedioTo());
	        series3.set(3, l1.getPromedioTo());
	        series3.set(4, l1.getPromedioTo());
	        series3.set(5,l1.getPromedioTo());
	        series3.set(6, l1.getPromedioTo());
	        
	        LineChartSeries series4 = new LineChartSeries();
	        series4.setLabel("Limite Minimo Desvicion");
	 
	        series4.set(1, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        series4.set(2, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        series4.set(3, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        series4.set(4, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        series4.set(5, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        series4.set(6, ((l1.getPromedioTo()-l1.getDessoltotal())));
	        	        
		
	        model.addSeries(series1);
	        model.addSeries(series2);
	        model.addSeries(series3);
	        model.addSeries(series4);
	        
	        return model;
	        
	}
	private LineChartModel lineas2(MuestraFisoQuimico l2) {
		
			
		
		LineChartModel model=new LineChartModel();
		
			
		 LineChartSeries series1 = new LineChartSeries();
	        series1.setLabel("Solidos");
	 
	        series1.set(1, l2.getOpsolidosfijo1());
	        series1.set(2, l2.getOpsolidosfijo2());
	        series1.set(3, l2.getOpsolidosfijo3());
	        series1.set(4, l2.getOpsolidosfijo4());
	        series1.set(5, l2.getOpsolidosfijo5());
	        series1.set(6, l2.getOpsolidosfijo6());
		
		 LineChartSeries series2 = new LineChartSeries();
	        series2.setLabel("Limite Maximo Desviacion");
	 
	        series2.set(1, ((l2.getPromedioFi()+l2.getDessolfi())));
	        series2.set(2, ((l2.getPromedioFi()+l2.getDessolfi())));
	        series2.set(3, ((l2.getPromedioFi()+l2.getDessolfi())));
	        series2.set(4, ((l2.getPromedioFi()+l2.getDessolfi())));
	        series2.set(5, ((l2.getPromedioFi()+l2.getDessolfi())));
	        series2.set(6, ((l2.getPromedioFi()+l2.getDessolfi())));
	        
	        
	        LineChartSeries series3 = new LineChartSeries();
	        series3.setLabel("Promedio");
	 
	        series3.set(1, l2.getPromedioFi());
	        series3.set(2, l2.getPromedioFi());
	        series3.set(3, l2.getPromedioFi());
	        series3.set(4, l2.getPromedioFi());
	        series3.set(5, l2.getPromedioFi());
	        series3.set(6, l2.getPromedioFi());
	        
	        LineChartSeries series4 = new LineChartSeries();
	        series4.setLabel("Limite Minimo Desvicion");
	 
	        series4.set(1, ((l2.getPromedioFi()-l2.getDessolfi())));
	        series4.set(2, ((l2.getPromedioFi()-l2.getDessolfi())));
	        series4.set(3, ((l2.getPromedioFi()-l2.getDessolfi())));
	        series4.set(4, ((l2.getPromedioFi()-l2.getDessolfi())));
	        series4.set(5, ((l2.getPromedioFi()-l2.getDessolfi())));
	        series4.set(6, ((l2.getPromedioFi()-l2.getDessolfi())));
	        	        
		
	        model.addSeries(series1);
	        model.addSeries(series2);
	        model.addSeries(series3);
	        model.addSeries(series4);
	        
	        return model;
	        
	}
	private LineChartModel lineas3(MuestraFisoQuimico l3) {
	
	
	
	LineChartModel model=new LineChartModel();
	
		
	 LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Solidos");
 
        series1.set(1, l3.getOpsolidosvolatil1());
        series1.set(2, l3.getOpsolidosvolatil2());
        series1.set(3, l3.getOpsolidosvolatil3());
        series1.set(4, l3.getOpsolidosvolatil4());
        series1.set(5, l3.getOpsolidosvolatil5());
        series1.set(6, l3.getOpsolidosvolatil6());
	
	 LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Limite Maximo Desviacion");
 
        series2.set(1, ((l3.getPromedioVo()+l3.getDessolvol())));
        series2.set(2, ((l3.getPromedioVo()+l3.getDessolvol())));
        series2.set(3, ((l3.getPromedioVo()+l3.getDessolvol())));
        series2.set(4, ((l3.getPromedioVo()+l3.getDessolvol())));
        series2.set(5, ((l3.getPromedioVo()+l3.getDessolvol())));
        series2.set(6, ((l3.getPromedioVo()+l3.getDessolvol())));
        
        
        LineChartSeries series3 = new LineChartSeries();
        series3.setLabel("Promedio");
 
        series3.set(1, l3.getPromedioVo());
        series3.set(2, l3.getPromedioVo());
        series3.set(3, l3.getPromedioVo());
        series3.set(4, l3.getPromedioVo());
        series3.set(5, l3.getPromedioVo());
        series3.set(6, l3.getPromedioVo());
        
        LineChartSeries series4 = new LineChartSeries();
        series4.setLabel("Limite Minimo Desvicion");
 
        series4.set(1, ((l3.getPromedioVo()-l3.getDessolvol())));
        series4.set(2, ((l3.getPromedioVo()-l3.getDessolvol())));
        series4.set(3, ((l3.getPromedioVo()-l3.getDessolvol())));
        series4.set(4, ((l3.getPromedioVo()-l3.getDessolvol())));
        series4.set(5, ((l3.getPromedioVo()-l3.getDessolvol())));
        series4.set(6, ((l3.getPromedioVo()-l3.getDessolvol())));
        	        
	
        model.addSeries(series1);
        model.addSeries(series2);
        model.addSeries(series3);
        model.addSeries(series4);
        
        return model;
        
}
	
	private BarChartModel lineas4 (MuestraFisoQuimico l4) {
		BarChartModel model = new BarChartModel();
		
		ChartSeries st = new ChartSeries();
		st.setLabel("% Solidos Totales");
		st.set(1, (l4.getOpsolidostotal1())/100);
		st.set(2, (l4.getOpsolidostotal2())/100);
		st.set(3, (l4.getOpsolidostotal3())/100);
		st.set(4, (l4.getOpsolidostotal4())/100);
		st.set(5, (l4.getOpsolidostotal5())/100);
		st.set(6, (l4.getOpsolidostotal6())/100);
		
		
		ChartSeries sf = new ChartSeries();
		sf.setLabel("% Solidos Fijos");
		sf.set(1, (l4.getOpsolidosfijo1())/100);
		sf.set(2, (l4.getOpsolidosfijo2())/100);
		sf.set(3,( l4.getOpsolidosfijo3())/100);
		sf.set(4,( l4.getOpsolidosfijo4())/100);
		sf.set(5, (l4.getOpsolidosfijo5())/100);
		sf.set(6, (l4.getOpsolidosfijo6())/100);
		
		
		
		ChartSeries sv = new ChartSeries();
		sv.setLabel("% Solidos Volatiles");
		sv.set(1, (l4.getOpsolidosvolatil1())/100);
		sv.set(2, (l4.getOpsolidosvolatil2())/100);
		sv.set(3, (l4.getOpsolidosvolatil3())/100);
		sv.set(4,( l4.getOpsolidosvolatil4())/100);
		sv.set(5, (l4.getOpsolidosvolatil5())/100);
		sv.set(6, (l4.getOpsolidosvolatil6())/100);
		
				
		model.addSeries(st);
		model.addSeries(sf);
		model.addSeries(sv);
		
		return model;
	}
	
	 private CartesianChartModel lineas5 (MuestraFisoQuimico l5) {
		 CartesianChartModel   model = new BarChartModel();
		 
		 	BarChartSeries st = new  BarChartSeries();
			st.setLabel("% Solidos Totales");
			st.set(1, (l5.getOpsolidostotal1())/100);
			st.set(2, (l5.getOpsolidostotal2())/100);
			st.set(3, (l5.getOpsolidostotal3())/100);
			st.set(4, (l5.getOpsolidostotal4())/100);
			st.set(5, (l5.getOpsolidostotal5())/100);
			st.set(6, (l5.getOpsolidostotal6())/100);
			
			
			BarChartSeries sf = new  BarChartSeries();
			sf.setLabel("% Solidos Fijos");
			sf.set(1, (l5.getOpsolidosfijo1())/100);
			sf.set(2, (l5.getOpsolidosfijo2())/100);
			sf.set(3,( l5.getOpsolidosfijo3())/100);
			sf.set(4,( l5.getOpsolidosfijo4())/100);
			sf.set(5, (l5.getOpsolidosfijo5())/100);
			sf.set(6, (l5.getOpsolidosfijo6())/100);
			
			
			
			BarChartSeries sv = new  BarChartSeries();
			sv.setLabel("% Solidos Volatiles");
			sv.set(1, (l5.getOpsolidosvolatil1())/100);
			sv.set(2, (l5.getOpsolidosvolatil2())/100);
			sv.set(3, (l5.getOpsolidosvolatil3())/100);
			sv.set(4,( l5.getOpsolidosvolatil4())/100);
			sv.set(5, (l5.getOpsolidosvolatil5())/100);
			sv.set(6, (l5.getOpsolidosvolatil6())/100);
			
			
           
			LineChartSeries dst1 = new LineChartSeries();
			dst1.set(1,(((l5.getPromedioTo()-l5.getDessoltotal()))/100));
			dst1.set(1,(((l5.getPromedioTo()+l5.getDessoltotal()))/100));
//			LineChartSeries dst2 = new LineChartSeries();
//			dst2.set(1,(((l5.getPromedioTo()-l5.getDessoltotal()))/100));
//			dst2.set(2,(((l5.getPromedioTo()+l5.getDessoltotal()))/100));
//			LineChartSeries dst3 = new LineChartSeries();
//			dst3.set(1,(((l5.getPromedioTo()-l5.getDessoltotal()))/100));
//			dst3.set(2,(((l5.getPromedioTo()+l5.getDessoltotal()))/100));
			
			
			
//			LineChartSeries dsf1 = new LineChartSeries();
//			dsf1.set(1,(((l5.getPromedioFi()-l5.getDessolfi()))/100));
//			dsf1.set(1,(((l5.getPromedioFi()+l5.getDessolfi()))/100));
//			LineChartSeries dsf2= new LineChartSeries();
//			dsf2.set(2,(((l5.getPromedioFi()-l5.getDessolfi()))/100));
//			dsf2.set(2,(((l5.getPromedioFi()+l5.getDessolfi()))/100));
//			LineChartSeries dsf3 = new LineChartSeries();
//			dsf3.set(3,(((l5.getPromedioFi()-l5.getDessolfi()))/100));
//			dsf3.set(3,(((l5.getPromedioFi()+l5.getDessolfi()))/100));
//			
//			
//			
//			LineChartSeries dsv1= new LineChartSeries();
//			dsv1.set(1,(((l5.getPromedioVo()-l5.getDessolvol()))/100));
//			dsv1.set(1,(((l5.getPromedioVo()+l5.getDessolvol()))/100));
//			LineChartSeries dsv2= new LineChartSeries();
//			dsv2.set(2,(((l5.getPromedioVo()-l5.getDessolvol()))/100));
//			dsv2.set(2,(((l5.getPromedioVo()+l5.getDessolvol()))/100));
//			LineChartSeries dsv3= new LineChartSeries();
//			dsv3.set(3,(((l5.getPromedioVo()-l5.getDessolvol()))/100));
//			dsv3.set(3,(((l5.getPromedioVo()+l5.getDessolvol()))/100));
			
	       
			
			model.addSeries(st);
			model.addSeries(sf);
			model.addSeries(sv);
			
			model.addSeries(dst1);
			
			
			
			
	        
	        return model;
	        
	 }

	public MuestraFisoQuimico getMuestrafisoquimico() {
		return muestrafisoquimico;
	}

	public void setMuestrafisoquimico(MuestraFisoQuimico muestrafisoquimico) {
		this.muestrafisoquimico = muestrafisoquimico;
	}



	public LineChartModel getLineModel1() {
		return lineModel1;
	}



	public void setLineModel1(LineChartModel lineModel1) {
		this.lineModel1 = lineModel1;
	}



	public LineChartModel getLineModel2() {
		return lineModel2;
	}



	public void setLineModel2(LineChartModel lineModel2) {
		this.lineModel2 = lineModel2;
	}



	public LineChartModel getLineModel3() {
		return lineModel3;
	}



	public void setLineModel3(LineChartModel lineModel3) {
		this.lineModel3 = lineModel3;
	}



	public BarChartModel getBarModel() {
		return barModel;
	}



	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}



	public CartesianChartModel getCombinedModel() {
		return combinedModel;
	}



	public void setCombinedModel(CartesianChartModel combinedModel) {
		this.combinedModel = combinedModel;
	}



}
