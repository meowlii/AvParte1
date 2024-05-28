package com.example.demoBiblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoBiblioteca.entities.Livro;
import com.example.demoBiblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}
	
	public Livro getLivrosById(long livrocodigo) {
		return livroRepository.findById(livrocodigo).orElse(null);
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	
	//query method buscar por titulo
	public List<Livro> buscarPorTitulo(String titulo) {
		return livroRepository.buscarPorTitulo(titulo);
	}

	//query method buscar por autor
	public List<Livro> buscarPorAutor(String autor) {
		return livroRepository.findByAutor(autor);
	}

}
