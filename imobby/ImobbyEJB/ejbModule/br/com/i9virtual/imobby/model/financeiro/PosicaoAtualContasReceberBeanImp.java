/**
 * Copyright (c) 2013
 * Propriedade do laborat�rio de desenvolvimento da i9Virtual
 * Todos os direitos reservados com base nas leis brasileiras de copyright
 * Este software � confidencial e de propriedade intelectual do
 * Laborat�rio de desenvolvimento da (c) i9Virtual
 * ******************************************************************************
 * Projeto: ImobbyEJB
 * Arquivo: PosicaoAtualContasReceberBeanImp.java
 * ******************************************************************************
 * Hist�rico de Revis�es
 * CR		Nome				Data                 Descri��o
 * ******************************************************************************
 * 			Pio Tofanelli           	01/08/2013              Vers�o Inicial
 * 
 */
package br.com.i9virtual.imobby.model.financeiro;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import br.com.i9virtual.imobby.dao.financeiro.PosicaoAtualContasReceberDao;
import br.com.i9virtual.imobby.entity.financeiro.PosicaoAtualContasReceber;

/**
 * @author Pio Tofanelli
 * @email  ptofanelli@i9virtual.com.br
 * @since  01/08/2013
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PosicaoAtualContasReceberBeanImp implements PosicaoAtualContasReceberBean {

	@EJB
	private PosicaoAtualContasReceberDao dao;
	
	@Override
	public PosicaoAtualContasReceber obter() {
		List<PosicaoAtualContasReceber> lista = dao.findAll();
		return lista.get(0);
	}

}
