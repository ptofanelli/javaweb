/**
 * Copyright (c) 2013
 * Propriedade do laboratório de desenvolvimento da i9Virtual
 * Todos os direitos reservados com base nas leis brasileiras de copyright
 * Este software é confidencial e de propriedade intelectual do
 * Laboratório de desenvolvimento da (c) i9Virtual
 * ******************************************************************************
 * Projeto: ImobbyEJB
 * Arquivo: PosicaoAtualContasReceber.java
 * ******************************************************************************
 * Histórico de Revisões
 * CR		Nome				Data                 Descrição
 * ******************************************************************************
 * 			Pio Tofanelli           	01/08/2013              Versão Inicial
 * 
 */
package br.com.i9virtual.imobby.entity.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pio Tofanelli
 * @email  ptofanelli@i9virtual.com.br
 * @since  01/08/2013
 */
@Entity(name = "PosicaoAtualContasReceber")
@Table(name = "FIN_POSATUCR")
public class PosicaoAtualContasReceber implements Serializable {

	/**
	 * Numero serial da classe
	 */
	private static final long serialVersionUID = -4807659587760505667L;

	@Id
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="SALDO", nullable=false)
	private BigDecimal saldo;
	
	@Column(name="SALDOATR", nullable=false)
	private BigDecimal saldoEmAtraso;

	/** 
	 * Metodo acessor do atributo saldo
	 * @return saldo
	 */
	public BigDecimal getSaldo() {
		return saldo;
	}

	/** 
	 * Metodo de atribuicao do atributo saldo
	 * @param saldo a ser atribuido em saldo
	 */
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	/** 
	 * Metodo acessor do atributo saldoEmAtraso
	 * @return saldoEmAtraso
	 */
	public BigDecimal getSaldoEmAtraso() {
		return saldoEmAtraso;
	}

	/** 
	 * Metodo de atribuicao do atributo saldoEmAtraso
	 * @param saldoEmAtraso a ser atribuido em saldoEmAtraso
	 */
	public void setSaldoEmAtraso(BigDecimal saldoEmAtraso) {
		this.saldoEmAtraso = saldoEmAtraso;
	}
	
}
