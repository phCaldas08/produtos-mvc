package br.com.fiap.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.fiap.model.CategoriaModel;

@Repository
public class CategoriaRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<CategoriaModel> findAll() {
		List<CategoriaModel> categorias = jdbcTemplate.query("SELECT * FROM TB_CATEGORIA",
				new BeanPropertyRowMapper<CategoriaModel>(CategoriaModel.class));

		return categorias;
	}

	public CategoriaModel findById(long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?",
				new BeanPropertyRowMapper<CategoriaModel>(CategoriaModel.class), id);
	}

	public void insert(CategoriaModel categoriaModel) {
		jdbcTemplate.update("INSERT INTO TB_CATEGORIA (NOME_CATEGORIA) VALUES(?)", categoriaModel.getNomeCategoria());
	}
	
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM TB_CATEGORIA WHERE ID_CATEGORIA = ?", id);
	}
}
