/**
 * 
 */
package br.com.i9virtual.imobby.model.financeiro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.i9virtual.imobby.dao.entidade.EntidadeDao;
import br.com.i9virtual.imobby.entity.entidade.Entidade;
import br.com.i9virtual.imobby.entity.entidade.Entidade.EntidadeChave;

/**
 * @author Pio Tofanelli
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EntidadeBeanImp implements EntidadeBean {

	@EJB
	private EntidadeDao entidadeDao;

	@Override
	public List<Entidade> listar() {
		return entidadeDao.findAll();
	}

	@Override
	public Entidade buscar(EntidadeChave chave) {
		return entidadeDao.buscar(chave);
	}

	@Override
	public List<Entidade> listarClientes() {
		return entidadeDao.listarClientes();
	}

	@Override
	public List<Entidade> listarFornecedores() {
		return entidadeDao.listarFornecedores();
	}
}
