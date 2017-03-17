/**
 * 
 */
package br.com.i9virtual.imobby.controller.entidade;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.com.i9virtual.imobby.entity.entidade.Entidade;
import br.com.i9virtual.imobby.model.financeiro.EntidadeBean;

/**
 * @author Pio Tofanelli
 *
 */
@SessionScoped
@Named("entidadeController")
public class EntidadeController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5770997292927595649L;
	
	@EJB
	private EntidadeBean entidadeBean;
	
	private List<Entidade> clientes;
	
	private Entidade clienteSelecionado;
	
	private List<Entidade> fornecedores;
	
	private Entidade fornecedorSelecionado;
	
	@PostConstruct
	public void iniciar()
	{
		//clientes = entidadeBean.listarClientes();
		//fornecedores = entidadeBean.listarFornecedores();
	}

	/** 
	 * Metodo acessor do atributo clientes
	 * @return clientes
	 */
	public List<Entidade> getClientes() {
		return clientes;
	}

	/** 
	 * Metodo acessor do atributo fornecedores
	 * @return fornecedores
	 */
	public List<Entidade> getFornecedores() {
		return fornecedores;
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
	 * Metodo acessor do atributo fornecedorSelecionado
	 * @return fornecedorSelecionado
	 */
	public Entidade getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	/** 
	 * Metodo de atribuicao do atributo fornecedorSelecionado
	 * @param fornecedorSelecionado a ser atribuido em fornecedorSelecionado
	 */
	public void setFornecedorSelecionado(Entidade fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	
	public String carregarClientes(){
		System.out.println("String carregarClientes()");
		return "pm:viewClientesResumo";
	}
	
	public void carregarClientes(ActionEvent action) {
		System.out.println("void carregarClientes(ActionEvent action)");
		if(clientes == null) {
			clientes = entidadeBean.listarClientes();
		}
	}
	
	public String carregarFornecedores(){
		System.out.println("String carregarFornecedores()");
		return "pm:viewFornecedoresResumo";
	}
	
	public void carregarFornecedores(ActionEvent action) {
		System.out.println("void carregarFornecedores(ActionEvent action)");
		if(fornecedores == null) {
			fornecedores = entidadeBean.listarFornecedores();
		}
	}

}
