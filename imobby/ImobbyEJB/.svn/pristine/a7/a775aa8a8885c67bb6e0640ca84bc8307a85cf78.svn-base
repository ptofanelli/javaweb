/**
 * 
 */
package br.com.i9virtual.imobby.dao.entidade;

import java.util.List;

import javax.ejb.Local;

import br.com.i9virtual.imobby.dao.GenericRepository;
import br.com.i9virtual.imobby.entity.entidade.Entidade;

/**
 * @author Pio Tofanelli
 *
 */
@Local
public interface EntidadeDao extends GenericRepository<Entidade, Long> {

	public Entidade buscar(final Entidade.EntidadeChave chave);
	
	public List<Entidade> listarClientes();
	
	public List<Entidade> listarFornecedores();
}
