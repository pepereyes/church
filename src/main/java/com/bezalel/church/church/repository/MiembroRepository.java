package com.bezalel.church.church.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bezalel.church.church.entities.Miembro;

@Repository
public interface MiembroRepository extends JpaRepository<Miembro, Long> {
	
}
