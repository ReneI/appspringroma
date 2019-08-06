package com.roma.candidato.negocio.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.roma.candidato.modelo.Tipos;


public interface TiposRepository extends JpaRepository<Tipos, Integer> {


	/*
	 * @Query("SELECT c from Tipos c where c.nameType =:vacanteCandidato") public
	 * Tipos findByNameType(@Param("vacanteCandidato")Integer vacanteCandidato );
	 */
	
public Tipos findByIdType(Integer identificacionCli);


}
