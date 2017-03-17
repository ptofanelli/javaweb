/**
 * 
 */
package br.com.i9virtual.imobby.dao.entidade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import br.com.i9virtual.imobby.dao.AbstractGenericRepository;
import br.com.i9virtual.imobby.entity.entidade.Entidade;


/**
 * @author Pio Tofanelli
 *
 */
@Stateless
public class EntidadeDaoImp extends AbstractGenericRepository<Entidade, Long> implements EntidadeDao{

	@Override
	public Entidade buscar(final Entidade.EntidadeChave chave) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		List<Entidade> entidades = null;
		
		parametros.put("empresa", chave.getEmpresa());
		parametros.put("entidade", chave.getEntidade());
		parametros.put("tipoEntidade", chave.getTipoEntidade().getTipo());
		
		entidades = findByNamedQuery("Entidade.buscarPorEmpEntidadeTipoEnt", parametros, 1);
		
		if(entidades.size() > 0){
			return entidades.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<Entidade> listarClientes() {
		return findByNamedQuery("Entidade.listarClientes", 50);
	}

	@Override
	public List<Entidade> listarFornecedores() {
		return findByNamedQuery("Entidade.listarFornecedores", 50);
	}

}
