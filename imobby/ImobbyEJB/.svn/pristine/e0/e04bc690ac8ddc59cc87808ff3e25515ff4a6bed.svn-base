/**
 * 
 */
package br.com.i9virtual.imobby.model.financeiro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.i9virtual.imobby.dao.financeiro.SaldoClienteDao;
import br.com.i9virtual.imobby.entity.financeiro.SaldoCliente;
import br.com.i9virtual.imobby.financeiro.ResumoSaldoCliente;

/**
 * @author Pio Tofanelli
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SaldoClienteBeanImp implements SaldoClienteBean {

	@EJB
	private SaldoClienteDao dao;
	
	@Override
	public List<SaldoCliente> listar() {
		return dao.findAll();
	}

	@Override
	public SaldoCliente primeiro() {
		return dao.findById((long) 1);
	}

	@Override
	public ResumoSaldoCliente obterResumoSaldoCliente() {
		ResumoSaldoCliente resumoSaldoCliente = new ResumoSaldoCliente();
		List<SaldoCliente> saldoClientes = null;
		
		// Menor SaldoCliente
		saldoClientes = dao.findByNamedQuery("SaldoCliente.menorSaldoCliente", 1);
		if(saldoClientes != null)
		{
			SaldoCliente saldoCliente =  saldoClientes.get(0);
			
			if(saldoCliente != null)
			{
				resumoSaldoCliente.setMenorSaldoCliente(saldoCliente);
			}
		}
		
		// Maior SaldoCliente
		saldoClientes = dao.findByNamedQuery("SaldoCliente.maiorSaldoCliente", 1);
		if(saldoClientes != null)
		{
			SaldoCliente saldoCliente =  saldoClientes.get(0);
			
			if(saldoCliente != null)
			{
				resumoSaldoCliente.setMaiorSaldoCliente(saldoCliente);
			}
		}
		
		// Menor SaldoCliente em atraso
		saldoClientes = dao.findByNamedQuery("SaldoCliente.menorSaldoClienteEmAtraso", 1);
		if(saldoClientes != null)
		{
			SaldoCliente saldoCliente =  saldoClientes.get(0);
			
			if(saldoCliente != null)
			{
				resumoSaldoCliente.setMenorSaldoClienteAtrasado(saldoCliente);
			}
		}
		
		// Maior SaldoCliente em atraso
		saldoClientes = dao.findByNamedQuery("SaldoCliente.maiorSaldoClienteEmAtraso", 1);
		if(saldoClientes != null)
		{
			SaldoCliente saldoCliente =  saldoClientes.get(0);
			
			if(saldoCliente != null)
			{
				resumoSaldoCliente.setMaiorSaldoClienteAtrasado(saldoCliente);
			}
		}
		
		return resumoSaldoCliente;
	}

	@Override
	public List<SaldoCliente> maioresSaldos(int quantidade) {
		return dao.listarMaioresSaldos(quantidade);
	}

}
