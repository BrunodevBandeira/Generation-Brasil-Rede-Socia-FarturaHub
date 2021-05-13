package com.hub.farturahub.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hub.farturahub.Repository.PostagemRepository;
import com.hub.farturahub.model.Postagem;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
/*@GetMapping("/regiao/{regiao}")
	public ResponseEntity<List<Postagem>> getByRegiao(@PathVariable String regiao){
		return ResponseEntity.ok(repository.findAllByRegiaoContainingIgnoreCase(regiao));
	}
*/	
	//busca de postagem por meio do texto/descrição/conteúdo
	@GetMapping("/postagem/{descricao}")
	public ResponseEntity<List<Postagem>> getByRegiao(@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	
	@PostMapping
	public ResponseEntity<Postagem> post(@RequestBody Postagem post){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(post));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> put(@RequestBody Postagem post){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(post));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
