package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}
