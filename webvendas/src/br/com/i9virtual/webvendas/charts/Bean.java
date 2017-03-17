package br.com.i9virtual.webvendas.charts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.chart.PieChartModel;

import com.googlecode.wickedcharts.highcharts.options.Axis;
import com.googlecode.wickedcharts.highcharts.options.ChartOptions;
import com.googlecode.wickedcharts.highcharts.options.HorizontalAlignment;
import com.googlecode.wickedcharts.highcharts.options.Legend;
import com.googlecode.wickedcharts.highcharts.options.LegendLayout;
import com.googlecode.wickedcharts.highcharts.options.Options;
import com.googlecode.wickedcharts.highcharts.options.SeriesType;
import com.googlecode.wickedcharts.highcharts.options.Title;
import com.googlecode.wickedcharts.highcharts.options.VerticalAlignment;
import com.googlecode.wickedcharts.highcharts.options.color.HexColor;
import com.googlecode.wickedcharts.highcharts.options.series.SimpleSeries;
import com.googlecode.wickedcharts.highcharts.theme.Theme;

@Named("bean")
@SessionScoped
public class Bean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5415741424082166996L;
	
	private PieChartModel model;
	
	private Options options;
	
	private Theme theme;
	
	private List<Produto> produtos;

	public Bean() {
		model = new PieChartModel();
		model.set("Produção", 540);
		model.set("Administrativo", 325);
		model.set("Transportes", 702);
		model.set("Outros", 421);
		model.setTitle("Despesas por Setor");
		model.setLegendPosition("w");
		
		this.loadChart();
		
		produtos = new ArrayList<Produto>();
		produtos.add(new Produto(1, "Produto 1", 23));
		produtos.add(new Produto(3, "Produto 2", 0));
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}



	public String setIdiomaPt() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("pt", "br"));
		return "";
	}
	
	public String setIdiomaEn() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
		return "";
	}
	
	public String setIdiomaEs() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("es"));
		return "";
	}

	public PieChartModel getModel() {
		return model;
	}
	
	public Options getOptions() {
		return options;
	}

	public Theme getTheme() {
		return theme;
	}

	private void loadChart() {
		theme = new Theme();
		// define the first three colors for all charts
		theme.addColor(new HexColor("#00FF00"));
		theme.addColor(new HexColor("#FF0000"));
		theme.addColor(new HexColor("#0000FF"));
		// defining the titles
		theme.setTitle(new Title("Title theme"));
		theme.setSubtitle(new Title("All charts using this theme will have this subtitle"));
		
		
		options = new Options();
	    options
	        .setChartOptions(new ChartOptions()
	            .setType(SeriesType.LINE));

	    options
	        .setTitle(new Title("Desempenho de Vendas"));

	    options
	        .setxAxis(new Axis()
	            .setCategories(Arrays
	                .asList(new String[] { "Jan", "Fev", "Mar", "Abr", "Mai",
	                    "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez" })));

	    options
	        .setyAxis(new Axis()
	            .setTitle(new Title("Valor (R$ mil)")));

	    options
	        .setLegend(new Legend()
	            .setLayout(LegendLayout.VERTICAL)
	            .setAlign(HorizontalAlignment.RIGHT)
	            .setVerticalAlign(VerticalAlignment.TOP)
	            .setX(-10)
	            .setY(100)
	            .setBorderWidth(0));

	    options
	        .addSeries(new SimpleSeries()
	            .setName("Particular")
	            .setData(
	                Arrays
	                    .asList(new Number[] { 7.0, 6.9, 9.5, 14.5, 18.2, 21.5,
	                        25.2, 26.5, 23.3, 18.3, 13.9, 9.6 })));

	    options
	        .addSeries(new SimpleSeries()
	            .setName("Média")
	            .setData(
	                Arrays
	                    .asList(new Number[] { 0.2, 0.8, 5.7, 11.3, 17.0, 22.0,
	                        24.8, 24.1, 20.1, 14.1, 8.6, 2.5 })));

	}
}
