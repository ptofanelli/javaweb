/**
 * 
 */
package br.com.i9virtual.imobby.model.financeiro;

import java.util.List;

import javax.ejb.Remote;

import br.com.i9virtual.imobby.entity.entidade.Entidade;

/**
 * @author Pio Tofanelli
 *
 */
@Remote
public interface EntidadeBean {

	public abstract List<Entidade> listar();
	
	public abstract Entidade buscar(Entidade.EntidadeChave chave);
	
	public abstract List<Entidade> listarClientes();
	
	public abstract List<Entidade> listarFornecedores();
}
