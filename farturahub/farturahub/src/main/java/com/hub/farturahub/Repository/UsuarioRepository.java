package com.hub.farturahub.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.farturahub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	public Optional<Usuario> findAllBycpfCnpjContainingIgnoreCase(String cpfCnpj);
	

}
