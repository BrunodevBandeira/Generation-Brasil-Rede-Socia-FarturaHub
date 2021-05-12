package com.hub.farturahub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hub.farturahub.model.Tema;


@Repository
public interface TemaRepository extends JpaRepository <Tema , Long>{
 public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao);
}
