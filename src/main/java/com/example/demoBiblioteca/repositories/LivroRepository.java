package com.example.demoBiblioteca.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demoBiblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	//buscar pot titulo
	@Query(value = "SELECT * FROM Livro l WHERE lower(l.titulo) LIKE %:titulo%", nativeQuery = true)
	List<Livro> buscarPorTitulo(@Param("titulo") String titulo);
	
	//busca por autor
	@Query("SELECT l FROM Livro l WHERE l.autor = ?l")
	List<Livro> findByAutor(String id_autor);
}