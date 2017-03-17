/**
 * 
 */
package br.com.i9virtual.imobby.model.financeiro;

import java.util.List;

import javax.ejb.Remote;

import br.com.i9virtual.imobby.entity.financeiro.SaldoCliente;
import br.com.i9virtual.imobby.financeiro.ResumoSaldoCliente;

/**
 * @author Pio Tofanelli
 *
 */
@Remote
public interface SaldoClienteBean {

	public abstract List<SaldoCliente> listar();
	
	public abstract SaldoCliente primeiro();
	
	public abstract ResumoSaldoCliente obterResumoSaldoCliente();
	
	public abstract List<SaldoCliente> maioresSaldos(int quantidade);
}
