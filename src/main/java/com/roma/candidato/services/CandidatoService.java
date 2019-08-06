/**
 * 
 */
package com.roma.candidato.services;

import com.roma.candidato.modelo.Candidato;
import com.roma.candidato.modelo.Tipos;
import com.roma.candidato.negocio.repository.CandidatoRepository;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @author bigei
 *
 */
@Service
@Transactional
public class CandidatoService {
	private final CandidatoRepository candidatoRepository;
	
	
	public CandidatoService(CandidatoRepository candidatoRepository) {
		
			this.candidatoRepository= candidatoRepository;	
	}
	
	
	public List<Candidato> findAll(){
		return this.candidatoRepository.findAll();
	}
	/**
	 * Metodo para insertar post 
	 * @param candidato
	 * @return
	 */
	@Transactional
	public Candidato create (Candidato candidato) {
		return this.candidatoRepository.save(candidato);
		
	

}	
	/**
	 * Metodo para actualizar 
	 * @param candidato
	 * @return
	 */
	
	
	@Transactional
	public Candidato update (Candidato candidato) {
		return this.candidatoRepository.save(candidato);
}
	
	
	
	/**
	 * Metodo para eliminar 
	 * @param candidato
	 * @return
	 */
	@Transactional
	public void delete (Candidato candidato) {
		this.candidatoRepository.delete(candidato);
		
	

}
	/**
	 * Método para consultar todos los clientes
	 * @return
	 */

	public Candidato findById(Integer id) {

		return this.candidatoRepository.findById(id).get();

	}	
	
	public List<Candidato> findByApellidos(String apellidos){
	 return this.candidatoRepository.findByApellidos(apellidos);
	}


	public List<Candidato> findByActivo(Boolean active) {
	return this.candidatoRepository.findByActivo(active);

		
		
	}

}