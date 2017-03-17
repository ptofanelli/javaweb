/**
 * 
 */
package br.com.i9virtual.imobby.controller.financeiro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.i9virtual.imobby.entity.entidade.Entidade;
import br.com.i9virtual.imobby.entity.financeiro.PosicaoAtualContasReceber;
import br.com.i9virtual.imobby.entity.financeiro.SaldoCliente;
import br.com.i9virtual.imobby.financeiro.ResumoSaldoCliente;
import br.com.i9virtual.imobby.model.financeiro.PosicaoAtualContasReceberBean;
import br.com.i9virtual.imobby.model.financeiro.SaldoClienteBean;

/**
 * @author Pio Tofanelli
 *
 */
@SessionScoped
@Named("saldoClienteController")
public class SaldoClienteController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3556038844677806114L;

	@EJB
	private SaldoClienteBean saldoClienteBean;
	
	@EJB
	private PosicaoAtualContasReceberBean posicaoAtualContasReceberBean;
	
	private Integer quantidadeMaioresSaldos = 5;
	
	private StreamedContent graficoSaldoEmAtraso;
	
	private List<SaldoCliente> maioresSaldos;
	
	private ResumoSaldoCliente resumoSaldoCliente;
	
	private PosicaoAtualContasReceber posicaoAtualContasReceber;
	
	private Entidade clienteSelecionado;
	
	private SaldoCliente saldoClienteSelecionado;
	
	private void createChart() throws IOException{
		//Chart
	    JFreeChart jfreechart = ChartFactory.createPieChart("Saldo Geral", createDataset(), true, true, false);
	    File chartFile = new File("graficoSaldoEmAtraso");
	    ChartUtilities.saveChartAsPNG(chartFile, jfreechart, 300, 250);
	    graficoSaldoEmAtraso = new DefaultStreamedContent(new FileInputStream(chartFile), "image/png");
	}

	private PieDataset createDataset() {
		NumberFormat numberFormatPorcentagem = NumberFormat.getPercentInstance();
		numberFormatPorcentagem.setMaximumFractionDigits(2);
		numberFormatPorcentagem.setMinimumFractionDigits(2);
		numberFormatPorcentagem.setMaximumIntegerDigits(3);
		numberFormatPorcentagem.setMinimumIntegerDigits(2);
		
		
		Double saldoPendente = 0.0;
		Double saldoAtrasado = 0.0;
		
		saldoPendente += posicaoAtualContasReceber.getSaldo().doubleValue();
		saldoAtrasado += posicaoAtualContasReceber.getSaldoEmAtraso().doubleValue();
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Pendente (" + numberFormatPorcentagem.format((1 - (saldoAtrasado / saldoPendente))) + ")", (1 - (saldoAtrasado / saldoPendente)));
		dataset.setValue("Atrasado (" + numberFormatPorcentagem.format((saldoAtrasado / saldoPendente)) + ")", (saldoAtrasado / saldoPendente));

		return dataset;
	}
	
	/**
	 * @return the graficoSaldoEmAtraso
	 */
	public StreamedContent getGraficoSaldoEmAtraso() {
		try {
			createChart();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			return null;
		}
		return graficoSaldoEmAtraso;
	}

	/** 
	 * Metodo acessor do atributo resumoSaldoCliente
	 * @return resumoSaldoCliente
	 */
	public ResumoSaldoCliente getResumoSaldoCliente() {
		return resumoSaldoCliente;
	}
	
	@PostConstruct
	private void iniciar(){	
//		resumoSaldoCliente = saldoClienteBean.obterResumoSaldoCliente();
//		maioresSaldos = saldoClienteBean.maioresSaldos(quantidadeMaioresSaldos);
//		posicaoAtualContasReceber = posicaoAtualContasReceberBean.obter();
	}

	/** 
	 * Metodo acessor do atributo quantidadeMaioresSaldos
	 * @return quantidadeMaioresSaldos
	 */
	public Integer getQuantidadeMaioresSaldos() {
		return quantidadeMaioresSaldos;
	}

	/** 
	 * Metodo de atribuicao do atributo quantidadeMaioresSaldos
	 * @param quantidadeMaioresSaldos a ser atribuido em quantidadeMaioresSaldos
	 */
	public void setQuantidadeMaioresSaldos(Integer quantidadeMaioresSaldos) {
		this.quantidadeMaioresSaldos = quantidadeMaioresSaldos;
	}

	/** 
	 * Metodo acessor do atributo maioresSaldos
	 * @return maioresSaldos
	 */
	public List<SaldoCliente> getMaioresSaldos() {
		return maioresSaldos;
	}
	
	public String atualizar()
	{
		System.out.println("public String atualizar() Called....");
		maioresSaldos = saldoClienteBean.maioresSaldos(quantidadeMaioresSaldos);
		return "";
	}
	
	public void atualizar(ActionEvent actionEvent) {
	    System.out.println("public void atualizar(ActionEvent actionEvent) Called....");
	    maioresSaldos = saldoClienteBean.maioresSaldos(quantidadeMaioresSaldos);
	}

	/** 
	 * Metodo acessor do atributo posicaoAtualContasReceber
	 * @return posicaoAtualContasReceber
	 */
	public PosicaoAtualContasReceber getPosicaoAtualContasReceber() {
		return posicaoAtualContasReceber;
	}

	/** 
	 * Metodo acessor do atributo clienteSelecionado
	 * @return clienteSelecionado
	 */
	public Entidade getClienteSelecionado() {
		return clienteSelecionado;
	}

	/** 
	 * Metodo de atribuicao do atributo clienteSelecionado
	 * @param clienteSelecionado a ser atribuido em clienteSelecionado
	 */
	public void setClienteSelecionado(Entidade clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	/** 
	 * Metodo acessor do atributo saldoClienteSelecionado
	 * @return saldoClienteSelecionado
	 */
	public SaldoCliente getSaldoClienteSelecionado() {
		return saldoClienteSelecionado;
	}

	/** 
	 * Metodo de atribuicao do atributo saldoClienteSelecionado
	 * @param saldoClienteSelecionado a ser atribuido em saldoClienteSelecionado
	 */
	public void setSaldoClienteSelecionado(SaldoCliente saldoClienteSelecionado) {
		this.saldoClienteSelecionado = saldoClienteSelecionado;
	}
	
	public String saldoClientes(){
		System.out.println("String saldoClientes()");
		
		return "pm:viewFinanceiroResumo";
	}
	
	public void saldoClientes(ActionEvent action) {
		System.out.println("void saldoClientes(ActionEvent action)");
		
		if(resumoSaldoCliente == null) {
			resumoSaldoCliente = saldoClienteBean.obterResumoSaldoCliente();
		}
		
		if(maioresSaldos == null) {
			maioresSaldos = saldoClienteBean.maioresSaldos(quantidadeMaioresSaldos);
		}
		
		if(posicaoAtualContasReceber == null) {
			posicaoAtualContasReceber = posicaoAtualContasReceberBean.obter();
		}
	}
	
}
