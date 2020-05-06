package br.com.fiap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.model.ProdutoModel;
import br.com.fiap.repository.ProdutoRepository;

@Controller
@RequestMapping(value = "/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping()
	public String findAll(Model model) {
		List<ProdutoModel> listProdutos = repository.findAll();
		
		model.addAttribute("produtos", listProdutos);
		
		return "produtos";
	}
	
	@GetMapping("/{id}")
	public String findById(@PathVariable("id") Long id, Model model) {
		ProdutoModel produto = repository.findById(id);
		
		model.addAttribute("produto", produto);
		
		return "produto-detalhe";
	}
	
	@GetMapping("/form")
	public String open(@RequestParam String page,
					   @RequestParam(required = false) Long id,
					   @ModelAttribute("produtoModel") ProdutoModel produtoModel,
					   Model model,
					   RedirectAttributes redirectAttributes) {
		
		switch(page) {
			case "produto-editar":
				model.addAttribute("produto", repository.findById(id));
				break;
			case "produto-novo":
				break;
			default:
				redirectAttributes.addFlashAttribute("messages", "Formulario nao encontrato!");
				page = "redirect:/produto";
				break;
		}
		
		return page;
	}
	
	
	@GetMapping("/new")
	//@ModelAttribute seta o model da tela
	public String openSave(@ModelAttribute("produtoModel") ProdutoModel produtoModel) {
		return "produto-novo";
	}
	
	@PostMapping()
	public String save(@Valid ProdutoModel produtoModel,
						BindingResult bindingResult, 
						RedirectAttributes redirectAttributes) {	
		
		if(bindingResult.hasErrors()) 
			return "produto-novo";		
		
		repository.save(produtoModel);
		redirectAttributes.addFlashAttribute("messages", "Produto cadastrado com sucesso!!!");
		
		return "redirect:/produto";
	}
	
	@GetMapping("/update/{id}")
	public String openUpdate(@PathVariable("id") Long id, Model model) {
		ProdutoModel produto = repository.findById(id);
		
		model.addAttribute("produto", produto);
		
		return "produto-editar";
	}
	
	@PutMapping()
	public String update(@Valid @ModelAttribute("produto") ProdutoModel produto,
						  BindingResult bindingResult,
						  RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) 
			return "produto-editar";		

		repository.update(produto);
		redirectAttributes.addFlashAttribute("messages", "Produto alterado com sucesso!!!");
		
		return "redirect:/produto";
				
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
		
		repository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages", "Produto removido com sucesso!!!");
		
		return "redirect:/produto";
	}

}
