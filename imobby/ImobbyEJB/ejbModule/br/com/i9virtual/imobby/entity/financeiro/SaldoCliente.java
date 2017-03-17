package br.com.i9virtual.imobby.entity.financeiro;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.i9virtual.imobby.entity.entidade.Entidade;

@Entity(name = "SaldoCliente")
@Table(name = "FIN_SALDOCLI")
@NamedQueries({
	@NamedQuery(name = "SaldoCliente.menorSaldoCliente", query = "select sc from SaldoCliente sc where sc.saldo = (SELECT MIN(sc.saldo) FROM sc)"),
	@NamedQuery(name = "SaldoCliente.maiorSaldoCliente", query = "select sc from SaldoCliente sc where sc.saldo = (SELECT MAX(sc.saldo) FROM sc)"),
	@NamedQuery(name = "SaldoCliente.menorSaldoClienteEmAtraso", query = "select sc from SaldoCliente sc where sc.saldoEmAtraso = (SELECT MIN(sc.saldoEmAtraso) FROM sc)"),
	@NamedQuery(name = "SaldoCliente.maiorSaldoClienteEmAtraso", query = "select sc from SaldoCliente sc where sc.saldoEmAtraso = (SELECT MAX(sc.saldoEmAtraso) FROM sc)")
})
public class SaldoCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9008223008635770034L;
	
	public static String COLUNA_ID = "id";
	public static String COLUNA_EMPRESA = "empresa";
	public static String COLUNA_ENTIDADE = "entidade";
	public static String COLUNA_TIPO_ENTIDADE = "tipoEntidade";
	public static String COLUNA_SALDO = "saldo";
	public static String COLUNA_SALDO_EM_ATRASO = "saldoEmAtraso";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="EMP", length=2, nullable=false)
	private String empresa;
	
	@Column(name="ENTIDADE", length=8, nullable=false)
	private String entidade;
	
	@Column(name="TIPOENT", length=1, nullable=false)
	private String tipoEntidade;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name="ENTIDADE", referencedColumnName="ENTIDADE", columnDefinition="VARCHAR(8)", insertable=false, updatable=false),
		@JoinColumn(name="EMP", referencedColumnName="EMP", columnDefinition="VARCHAR(2)", insertable=false, updatable=false),
		@JoinColumn(name="TIPOENT", referencedColumnName="TIPOENT", columnDefinition="VARCHAR(1)", insertable=false, updatable=false)
	})
	private Entidade entidadeObj;
	
	@Column(name="SALDO", nullable=false)
	private BigDecimal saldo;
	
	@Column(name="SALDOATR", nullable=false)
	private BigDecimal saldoEmAtraso;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getSaldoEmAtraso() {
		return saldoEmAtraso;
	}

	public void setSaldoEmAtraso(BigDecimal saldoEmAtraso) {
		this.saldoEmAtraso = saldoEmAtraso;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the entidade
	 */
	public String getEntidade() {
		return entidade;
	}

	/**
	 * @param entidade the entidade to set
	 */
	public void setEntidade(String entidade) {
		this.entidade = entidade;
	}

	/**
	 * @return the entidadeObj
	 */
	public Entidade getEntidadeObj() {
		return entidadeObj;
	}

	/**
	 * @param entidadeObj the entidadeObj to set
	 */
	public void setEntidadeObj(Entidade entidadeObj) {
		this.entidadeObj = entidadeObj;
	}

	/**
	 * @return the tipoEntidade
	 */
	public String getTipoEntidade() {
		return tipoEntidade;
	}

	/**
	 * @param tipoEntidade the tipoEntidade to set
	 */
	public void setTipoEntidade(String tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
	}

}
