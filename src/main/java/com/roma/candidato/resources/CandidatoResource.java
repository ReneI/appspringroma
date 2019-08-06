/**
 * 
 */
package com.roma.candidato.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roma.candidato.modelo.Candidato;
import com.roma.candidato.modelo.Tipos;

import com.roma.candidato.services.CandidatoService;
import com.roma.candidato.services.TiposService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import com.roma.candidato.resources.vo.CandidatoVO;

import org.springframework.data.mapping.*;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.*;

/**
 * @author bigei
 *
 */

@RestController
@RequestMapping("/api/candidato")
@Transactional
@Api(tags="Candidatos datos")
public class CandidatoResource {

	private final CandidatoService candidatoService;
	private final TiposService tiposService;
	
	public  CandidatoResource (CandidatoService candidatoService,TiposService tiposService) {
		this.candidatoService=candidatoService;
		this.tiposService=tiposService;
		
	}
	
		
	/**
	 * @param candidatoVO
	 * @return
	 */
	@PostMapping
	@ApiOperation(value="Crear nuevo candidato",notes="servicio para insertar nuevo candidatos, Se puede insertar tipo solo o insertar un nuevo tipo en el campo anidado")
	@ApiResponses(value= { @ApiResponse(code = 201, message="exitoso"),
			@ApiResponse(code = 400, message="error"),
			@ApiResponse(code = 500, message="erro interno del servidor ") })
	public ResponseEntity<Candidato> createCandidato(@RequestBody CandidatoVO candidatoVO){
	 Tipos tipo = tiposService.findByNameType(candidatoVO.getTipo().getIdType());	 
	 Candidato candidato = new Candidato();
		candidato.setTipo(tipo);
		candidato.setNombre(candidatoVO.getNombre());	
		candidato.setApellidos(candidatoVO.getApellidos());
		candidato.setActivo(candidatoVO.getActivo());
		Candidato result = candidatoService.create(candidato);
		System.out.println(candidato);
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	@GetMapping
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<List<Candidato>> findAll() {
		return ResponseEntity.ok(this.candidatoService.findAll());
	}
	
	


	@GetMapping("/{id}")
	@ApiOperation(value = "Listar Reservas", notes = "Servicio para listar todas las reservas")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Reservas encontrados"),
			@ApiResponse(code = 404, message = "Reservas no encontrados") })
	public ResponseEntity<Candidato>findId(@PathVariable("id") Integer id, CandidatoVO candidatoVO) {
		
		return ResponseEntity.ok(this.candidatoService.findById(id));
	}



	@PutMapping("/{id}")

	@ApiOperation(value = "Actualizar Candidato", notes = "Servicio para actualizar una candidato")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "candidato actualizada correctamente"),

			@ApiResponse(code = 404, message = "candidato no encontrado")})

	public ResponseEntity<Candidato> updateCandidato(@PathVariable("id") Integer id, CandidatoVO candidatoVO){

		Candidato candidato = this.candidatoService.findById(id);

		if(candidato == null) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}

		 Tipos tipo = tiposService.findByNameType(candidatoVO.getTipo().getIdType());	 

		if(tipo == null) {

			return new ResponseEntity<>(HttpStatus.OK);

		}
		candidato.setTipo(tipo);
		candidato.setNombre(candidatoVO.getNombre());	
		candidato.setApellidos(candidatoVO.getApellidos());
		candidato.setActivo(candidatoVO.getActivo());

		return new ResponseEntity<>(this.candidatoService.update(candidato), HttpStatus.OK);

	}
	
	
	
	@DeleteMapping("/{id}")

	@ApiOperation(value = "Eliminar candidato", notes = "Servicio para eliminar un candidato")

	@ApiResponses(value = { @ApiResponse(code = 200, message = "reserva eliminada correctamente"),

			@ApiResponse(code = 404, message = "Cliente no encontrado")})

	public void removeReserva(@PathVariable("id") Integer id) {

		Candidato candidato = this.candidatoService.findById(id);

		if(candidato != null) {

			this.candidatoService.delete(candidato);

		}

	}
	
	
	
	
}