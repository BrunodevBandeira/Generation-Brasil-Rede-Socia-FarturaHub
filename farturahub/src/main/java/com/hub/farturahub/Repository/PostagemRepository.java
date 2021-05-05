package com.hub.farturahub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.farturahub.model.Postagem;


public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	public List<Postagem> findAllByRegiaoContainingIgnoreCase(String regiao);
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
}
