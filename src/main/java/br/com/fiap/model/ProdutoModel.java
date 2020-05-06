package br.com.fiap.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProdutoModel {
	
	
	private Long id;
	
	@NotNull
	@NotBlank
	private String nome;
	
	private String sku;
	
	@Size(min = 1, max = 100)
	private String descricao;
	
	private String caracteristicas;
	
	@DecimalMin(value = "0.1", message = "O valor deve ser maior que R$0,10")
	private Double preco;
	
	//Construtor vazio para preenchimento do BeanMapper na classe ProdutoRepository
	public ProdutoModel() {
	}
	
	
	public ProdutoModel(Long id, String nome, String sku, String descricao, String caracteristicas, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sku = sku;
		this.descricao = descricao;
		this.caracteristicas = caracteristicas;
		this.preco = preco;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCaracteristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

}
