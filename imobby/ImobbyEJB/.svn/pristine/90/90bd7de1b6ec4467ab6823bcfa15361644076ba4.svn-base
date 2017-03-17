package br.com.i9virtual.imobby.entity.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name = "Entidade")
@Table(name = "ENT_CLIEFORN")
@NamedQueries({
	@NamedQuery(name = "Entidade.listarClientes", query = "select e from Entidade e where e.tipoEntidade = 'C'"),
	@NamedQuery(name = "Entidade.listarFornecedores", query = "select e from Entidade e where e.tipoEntidade = 'F'"),
	@NamedQuery(name = "Entidade.buscarPorEmpEntidadeTipoEnt", query = "select e from Entidade e where e.empresa = :empresa and e.entidade = :entidade and e.tipoEntidade = :tipoEntidade")
})
public class Entidade implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8173810022630400605L;

	@Id
	@Column(name="ID", nullable=false)
	private Long id;
	
	@Column(name="EMP", length=2, nullable=false)
	private String empresa;
	
	@Column(name="ENTIDADE", length=8, nullable=false)
	private String entidade;

	@Column(name="TIPOENT", length=1, nullable=false)
	private String tipoEntidade;
	
	@Column(name="NOME", length=50, nullable=false)
	private String nome;
	
	@Column(name="ENDERECO", length=40, nullable=false)
	private String endereco;
	
	@Column(name="EST", length=2, nullable=false)
	private String estado;
	
	@Column(name="CODMUN", length=5, nullable=false)
	private String codigoMunicipio;
	
	@Column(name="MUN", length=25, nullable=false)
	private String municipio;
	
	@Column(name="CEP", length=8, nullable=false)
	private String cep;
	
	@Column(name="BAIRRO", length=20, nullable=false)
	private String bairro;
	
	@Column(name="TEL", length=50, nullable=false)
	private String telefone;
	
	@Column(name="EMAIL", length=120, nullable=false)
	private String email;
	
	@Column(name="VEND", length=6, nullable=false)
	private String vendedor;
	
	public static enum TipoEntidade{
		CLIENTE("C"),
		FORNECEDOR("F"),
		VENDEDOR("V");
		
		private String tipo;
		
		private TipoEntidade(final String tipo) {
			this.tipo = tipo;
		}

		/**
		 * @return the tipo
		 */
		public String getTipo() {
			return tipo;
		}
	
	}
	
	
	public static class EntidadeChave implements Serializable{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 8928453251833537036L;

		private String empresa;
		
		private String entidade;
		
		private TipoEntidade tipoEntidade;

		public EntidadeChave() {}
		
		public EntidadeChave(final String empresa, final String entidade, final TipoEntidade tipoEntidade) {
			this.empresa = empresa;
			this.entidade = entidade;
			this.tipoEntidade = tipoEntidade;
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
		 * @return the tipoEntidade
		 */
		public TipoEntidade getTipoEntidade() {
			return tipoEntidade;
		}

		/**
		 * @param tipoEntidade the tipoEntidade to set
		 */
		public void setTipoEntidade(TipoEntidade tipoEntidade) {
			this.tipoEntidade = tipoEntidade;
		}
		
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the codigoMunicipio
	 */
	public String getCodigoMunicipio() {
		return codigoMunicipio;
	}

	/**
	 * @param codigoMunicipio the codigoMunicipio to set
	 */
	public void setCodigoMunicipio(String codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	/**
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * @param vendedor the vendedor to set
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
}
