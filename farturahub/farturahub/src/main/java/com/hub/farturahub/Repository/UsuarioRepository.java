package com.hub.farturahub.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.hub.farturahub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	public List<Usuario> findAllBycpfCnpjContainingIgnoreCase(String cpfCnpj);
	

}
