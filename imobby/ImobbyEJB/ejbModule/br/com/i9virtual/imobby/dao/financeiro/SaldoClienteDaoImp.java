/**
 * 
 */
package br.com.i9virtual.imobby.dao.financeiro;

import java.util.List;

import javax.ejb.Stateless;

import br.com.i9virtual.imobby.dao.AbstractGenericRepository;
import br.com.i9virtual.imobby.entity.financeiro.SaldoCliente;

/**
 * @author Pio Tofanelli
 *
 */
@Stateless
public class SaldoClienteDaoImp extends AbstractGenericRepository<SaldoCliente, Long> implements SaldoClienteDao {

	@Override
	public List<SaldoCliente> listarMaioresSaldos(int quantidade) {
		return find(SaldoCliente.COLUNA_SALDO, false, quantidade);
	}

}
