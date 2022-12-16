package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Persona;

@Repository
public interface IPersona extends JpaRepository<Persona, Long>{
//	List<Persona> findBypersonaIdentificacionContainingIgnoreCase(String term);
//	Optional<Persona> findByPersonaCodigo(Long personaCodigo);

//	@Query("select * from tb_persona where persona_identificacion ")
	public List<Persona> findBypersonaIdentificacionContainingIgnoreCase(String term);

	public Optional<Persona> findByPersonaCodigo(Long personaCodigo);


}
