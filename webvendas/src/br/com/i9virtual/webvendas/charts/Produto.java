package br.com.i9virtual.webvendas.charts;

public class Produto {

	private Integer codigo;
	private String descricao;
	private Integer estoque;
	 
	public Produto(Integer codigo, String descricao, Integer estoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.estoque = estoque;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	
}
