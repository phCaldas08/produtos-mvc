package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.ProdutoModel;

@Repository
public class ProdutoRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProdutoRepository() {
		
	}
	
	public List<ProdutoModel> findAll(){		
		return jdbcTemplate.query("SELECT * FROM TB_PRODUTO", new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class));
		
	}

	public ProdutoModel findById(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM TB_PRODUTO WHERE ID = ?", new BeanPropertyRowMapper<ProdutoModel>(ProdutoModel.class), id);
	}
	
	public void save(ProdutoModel produto) {
		jdbcTemplate.update("INSERT INTO TB_PRODUTO (NOME, SKU, DESCRICAO, PRECO, CARACTERISTICAS) VALUES(?,?,?,?,?)",
				produto.getNome(),
				produto.getSku(),
				produto.getDescricao(),
				produto.getPreco(),
				produto.getCaracteristicas()); 
		
	}
	
	
	public void update(ProdutoModel produto) {
		jdbcTemplate.update("UPDATE TB_PRODUTO SET NOME=?, SKU=?, DESCRICAO=?, PRECO=?, CARACTERISTICAS=? WHERE ID = ? ",
				produto.getNome(),
				produto.getSku(),
				produto.getDescricao(),
				produto.getPreco(),
				produto.getCaracteristicas(),
				produto.getId()); 
	}
	
	
	public void deleteById(long id) {
		jdbcTemplate.update("DELETE TB_PRODUTO WHERE ID=?", id);
	}
}
