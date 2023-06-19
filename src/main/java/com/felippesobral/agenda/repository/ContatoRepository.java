package com.felippesobral.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felippesobral.agenda.dominio.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {

}
