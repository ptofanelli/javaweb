package br.com.i9virtual.imobby.dao.financeiro;

import java.util.List;

import javax.ejb.Local;

import br.com.i9virtual.imobby.dao.GenericRepository;
import br.com.i9virtual.imobby.entity.financeiro.SaldoCliente;

@Local
public interface SaldoClienteDao extends GenericRepository<SaldoCliente, Long> {

	public List<SaldoCliente> listarMaioresSaldos(int quantidade);
}
