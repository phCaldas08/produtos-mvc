package br.com.fiap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fiap.model.CategoriaModel;
import br.com.fiap.repository.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public String getCategorias(Model model) {
		
		model.addAttribute("categorias", repository.findAll());
		
		return "categorias";		
		
	}
	
	@GetMapping("/{id}")
	public String getDetalhe(@PathVariable Long id, Model model) {
		model.addAttribute("categoria", repository.findById(id));
		
		return "categoria-detalhe";
	}
	
	@GetMapping("/form")
	public String getForm(@RequestParam String page, @ModelAttribute CategoriaModel categoriaModel) {
		
		return page;
	}
	
	@PostMapping
	public String postNovo(CategoriaModel categoriaModel) {
		repository.insert(categoriaModel);
		
		return "redirect:/categoria";
	}
	
	
	@DeleteMapping("/{id}")
	public String deleteCategoria(@PathVariable Long id) {
		repository.delete(id);
		
		return "redirect:/categoria";
	}
	
	
}
