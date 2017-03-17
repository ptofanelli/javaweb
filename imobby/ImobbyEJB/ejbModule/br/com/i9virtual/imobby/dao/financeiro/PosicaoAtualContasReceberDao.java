/**
 * Copyright (c) 2013
 * Propriedade do laborat�rio de desenvolvimento da i9Virtual
 * Todos os direitos reservados com base nas leis brasileiras de copyright
 * Este software � confidencial e de propriedade intelectual do
 * Laborat�rio de desenvolvimento da (c) i9Virtual
 * ******************************************************************************
 * Projeto: ImobbyEJB
 * Arquivo: PosicaoAtualContasReceberDao.java
 * ******************************************************************************
 * Hist�rico de Revis�es
 * CR		Nome				Data                 Descri��o
 * ******************************************************************************
 * 			Pio Tofanelli           	01/08/2013              Vers�o Inicial
 * 
 */
package br.com.i9virtual.imobby.dao.financeiro;

import javax.ejb.Local;

import br.com.i9virtual.imobby.dao.GenericRepository;
import br.com.i9virtual.imobby.entity.financeiro.PosicaoAtualContasReceber;

/**
 * @author Pio Tofanelli
 * @email  ptofanelli@i9virtual.com.br
 * @since  01/08/2013
 */
@Local
public interface PosicaoAtualContasReceberDao extends GenericRepository<PosicaoAtualContasReceber, Long> {

}
