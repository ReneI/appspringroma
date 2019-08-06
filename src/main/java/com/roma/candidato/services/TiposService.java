package com.roma.candidato.services;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roma.candidato.modelo.Tipos;
import com.roma.candidato.negocio.repository.TiposRepository;
@Service
@Transactional(readOnly=true)
public class TiposService {

	
	private final TiposRepository tipoRepository;
	
	public TiposService (TiposRepository tiposRepository) {
		
		this.tipoRepository = tiposRepository;
		
	}
	public List<Tipos> findAll(){
		return this.tipoRepository.findAll();
	}
	@Transactional
	public Tipos create(Tipos tipo) {
		return this.tipoRepository.save(tipo);
	}
	@Transactional
	public Tipos update(Tipos tipo) {
		return this.tipoRepository.save(tipo);
	}
	
	@Transactional
	public void delete(Tipos tipo) {
		 this.tipoRepository.delete(tipo);

		
	}
	

	public Tipos findByNameType(Integer v) {
		return this.tipoRepository.findByIdType(v);
	}


	
}
