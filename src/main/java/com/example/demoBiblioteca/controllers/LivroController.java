package com.example.demoBiblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demoBiblioteca.entities.Livro;
import com.example.demoBiblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final LivroService livroService;
	
	@Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public Livro createLivro(@RequestBody Livro livro) {
        return livroService.saveLivro(livro);
    }

    @GetMapping("/{id}")
    public Livro getLivro(@PathVariable Long id) {
        return livroService.getLivrosById(id);
    }

    @GetMapping
    public List<Livro> getAllLivros() {
        return livroService.getAllLivros();
    }

    @DeleteMapping("/{id}")
    public void deleteLivro(@PathVariable Long id) {
    	livroService.deleteLivro(id);
    }
  	
    //query method buscar titulo controler
  	@GetMapping("/titulo/{titulo}")
  	public List<Livro> buscarPorTitulo(@PathVariable String titulo) {
  		return livroService.buscarPorTitulo(titulo);
  	}
    
  	@GetMapping("/autor/{autor}")
  	public List<Livro> buscarPorAutor(@PathVariable String autor) {
  		return livroService.buscarPorAutor(autor);
  	}
}