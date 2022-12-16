package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Persona;

public interface IpersonaService {
	public List<Persona>listar(String term);
	public Optional<Persona>listarId(Long personaCodigo);
	public int save(Persona p);
	public void delete(Long personaCodigo);


}
