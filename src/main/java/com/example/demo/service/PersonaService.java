package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IpersonaService;
import com.example.demo.modelo.Persona;
import com.example.demo.repository.IPersona;


@Service
public class PersonaService implements IpersonaService {

	@Autowired
	private IPersona data;

	@Override
	public List<Persona> listar(String term) {
		return data.findBypersonaIdentificacionContainingIgnoreCase(term);
	}

	@Override
	public Optional<Persona> listarId(Long personaCodigo) {
		// TODO Auto-generated method stub
		return data.findByPersonaCodigo(personaCodigo);
	}



	@Override
	public int save(Persona p) {
		// TODO Auto-generated method stub
		int res=0;
		Persona persona=data.save(p);
		if (!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(Long personaCodigo) {
		// TODO Auto-generated method stub
		data.deleteById(personaCodigo);

	}





}
