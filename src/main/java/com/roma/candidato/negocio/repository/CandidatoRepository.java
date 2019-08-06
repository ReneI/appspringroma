package com.roma.candidato.negocio.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.roma.candidato.modelo.Candidato;
import com.roma.candidato.modelo.Tipos;
	/**
 * Interfaz para definir las operaciones de las base de datos
 * @author bigei
 *
 */

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {


	public List<Candidato> findByApellidos(String apellidos);
/*	  	public Candidato findByCandidato(String identificacionCa);
*
	*	@Query("SELECT e FROM  Candidato e WHERE e.activo = TRUE")
	* 	public List<Candidato>findActivos()
	* 	 @Query(value = "SELECT e FROM  Employee e WHERE e.activo=?1",nativeQuery = true)

	*//*
	*/
	
	    public List<Candidato> findByActivo(Boolean active);
}
