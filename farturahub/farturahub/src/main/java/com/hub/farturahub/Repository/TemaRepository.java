package com.hub.farturahub.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hub.farturahub.model.TemaModel;


@Repository
public interface TemaRepository extends JpaRepository <TemaModel , Long>{
 public List<TemaModel> findAllByDescricaoContainingIgnoreCase(String descricao);
}
